/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.boletin10;

import java.sql.Connection;
import java.sql.*;

/**
 * @author pepecalo
 */
public class ConnectionLibrary {

    public static final String URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\bd\\library"
            + ";DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    public static final String DRIVER = "org.h2.Driver";

    private static ConnectionLibrary instance;

    private Connection conexion;


    private ConnectionLibrary() {

    }

    public static ConnectionLibrary getInstance() {
        if (instance == null) {
            // esperas ti e eu
            synchronized (ConnectionLibrary.class) {
                if (instance == null) {
                    instance = new ConnectionLibrary();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (conexion == null || conexion.isClosed()) {
                synchronized (ConnectionLibrary.class) {
                    if (conexion == null) {
                        try {
                            Class.forName(DRIVER);
                            conexion = DriverManager.getConnection(URL);
                        } catch (ClassNotFoundException ex) {
                            System.err.println("Drivers non atopados.");
                        } catch (SQLException ex) {
                            System.err.println("Erro ó establecer a conexión: "
                                    + ex.getMessage());
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ó establecer a conexión: "
                    + e.getMessage());
        }
        return conexion;
    }


}
