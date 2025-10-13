package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {

    protected Connection conexion;
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres";
    private final String USER = "postgres.lvldoxjkilisktjsycrs";
    private final String PASS = "VZRX^uX*T@7x";

    public void Conectar() throws ClassNotFoundException, SQLException {
        // Propagate SQLException so callers can handle connection failures.
        Class.forName(JDBC_DRIVER);
        conexion = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void Cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}