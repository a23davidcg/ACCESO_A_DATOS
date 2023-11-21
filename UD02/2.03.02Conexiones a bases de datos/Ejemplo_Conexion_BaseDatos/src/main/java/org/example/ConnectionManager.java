package com.pepinho.ad.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String DB_URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\juego\\JuegosH2.mv.db";
    public static final String DB_DRIVER = "org.h2.Driver";

    private Connection conexion;

    public ConnectionManager(){
        try {
            Class.forName(DB_DRIVER);
            conexion = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Error al conectar coa base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver: " + e.getMessage());
        }
    }

    public Connection getConnection(){
        return conexion;
    }

}
