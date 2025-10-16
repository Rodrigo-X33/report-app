package com.mycompany.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database helper using HikariCP connection pool.
 *
 * Why: Opening raw JDBC connections per operation (DriverManager.getConnection)
 * can exhaust the server-side connection pooler when the app opens many
 * connections concurrently or doesn't reliably close them. Using a local
 * client-side pool (HikariCP) reuses connections and bounds concurrent
 * connections, preventing saturation of the remote pooler.
 */
public class Database {

    private static final Logger LOG = Logger.getLogger(Database.class.getName());
    private static HikariDataSource ds;

    // Connection parameters: keep them private and consider loading from env/config
    private static final String DB_URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.lvldoxjkilisktjsycrs";
    private static final String PASS = "VZRX^uX*T@7x";

    

    // -- Compatibility with existing DAOs that extend Database --
    // Many DAO implementations in this project expect to inherit a protected
    // `conexion` field and call instance methods Conectar/Cerrar. To keep them
    // working without changing all DAOs, provide the expected API while using
    // the HikariCP pool under the hood.
    protected Connection conexion;

    /** Public no-arg constructor for DAOs that extend Database. */
    public Database(boolean initPool) {
        // If called with initPool=true we ensure pool initialized; otherwise lazy
        if (initPool) initPool();
    }

    public Database() {
        // default public constructor for backward compatibility
    }

    /**
     * Instance-level connect: obtains a connection from the Hikari pool and
     * assigns it to the inherited `conexion` field. Caller should later call
     * Cerrar() to close the connection (returns it to the pool).
     */
    public void Conectar() throws SQLException {
        if (ds == null) initPool();
        this.conexion = ds.getConnection();
    }

    /**
     * Close the instance connection (return to pool) if present.
     */
    public void Cerrar() throws SQLException {
        if (this.conexion != null) {
            try {
                if (!this.conexion.isClosed()) this.conexion.close();
            } finally {
                this.conexion = null;
            }
        }
    }

    /**
     * Initialize the HikariCP datasource lazily.
     */
    private static synchronized void initPool() {
        if (ds != null) return;

        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl(DB_URL);
        cfg.setUsername(USER);
        cfg.setPassword(PASS);
        // recommended PostgreSQL driver class (Hikari detects automatically but explicit is fine)
        cfg.setDriverClassName("org.postgresql.Driver");

        // Pool tuning (adjust to your environment)
        cfg.setMaximumPoolSize(10); // max concurrent connections from app
        cfg.setMinimumIdle(2);
        cfg.setConnectionTimeout(30_000); // ms to wait for a connection from pool
        cfg.setIdleTimeout(300_000); // ms before an idle connection is removed
        cfg.setMaxLifetime(1_800_000); // ms max lifetime of a connection (30min)

        // Optional: test query
        cfg.setValidationTimeout(5_000);
        cfg.setConnectionTestQuery("SELECT 1");

        ds = new HikariDataSource(cfg);
        LOG.log(Level.INFO, "HikariCP pool initialized (maxPoolSize={0})", cfg.getMaximumPoolSize());
    }

    /**
     * Get a connection from the pool. Caller MUST close the connection (try-with-resources).
     */
    public static Connection getConnection() throws SQLException {
        if (ds == null) initPool();
        return ds.getConnection();
    }

    /**
     * Close the datasource and release resources. Call on application shutdown.
     */
    public static synchronized void closePool() {
        if (ds != null) {
            try {
                ds.close();
                LOG.info("HikariCP pool closed");
            } catch (Exception ex) {
                LOG.log(Level.WARNING, "Error closing HikariCP pool", ex);
            } finally {
                ds = null;
            }
        }
    }
}