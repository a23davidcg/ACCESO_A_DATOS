package com.pepinho.programacion.boletin10;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de tipo Singleton para gestionar la conexión a la base de datos.
 * Emplea el modelo Thread-safe con doble comprobación de la instancia.
 * Además, la conexión se realiza con el patrón DAO.
 */
public class ConnectionManager {
    private static final String URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\bd\\library;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";
    private static final int MAX_CONEXIONES = 5;

    private static ConnectionManager instance;

    // Mejora para tener un pool de conexiones

    private int actual = 0;
    private final Connection[] conexiones;

//    private final Connection conexion;

    private ConnectionManager() {
        conexiones = new Connection[MAX_CONEXIONES];
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            // Sincronizamos el acceso al array de conexiones
            synchronized (conexiones) {
                if (actual == MAX_CONEXIONES) {
                    actual = 0;
                }
                if (conexiones[actual] == null || conexiones[actual].isClosed()) {
                    Driver driver = DriverManager.getDriver(URL);
                    if (driver == null) {
                        throw new SQLException("No se ha encontrado el driver");
                    }
                    conexiones[actual] = DriverManager.getConnection(URL);
                }
                return conexiones[actual++];
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
