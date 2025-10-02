package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    protected Connection conexion;
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://lvldoxjkilisktjsycrs.supabase.co:5432/ilib";

    private final String USER = "postgres";
    private final String PASS = "VZRX^uX*T@7x";

    public void Conectar() throws ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}