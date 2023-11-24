package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryConnection {

    //Connection manager con patron singletone
    private static volatile LibraryConnection instance;
    private final String URL_DATABASE = "jdbc:h2:C:\\Users\\A23DavidCG\\Desktop\\library.mv.db";
    private final String USER_DATABASE = "";
    private final String PASS_DATABASE = "";

    private Connection con;

    private LibraryConnection() {
    }

    public Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(URL_DATABASE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    public static LibraryConnection getInstance() {
        if (instance == null) {
            synchronized (LibraryConnection.class) {
                if (instance == null) {
                    instance = new LibraryConnection();
                }
            }
        }
        return instance;
    }
}
