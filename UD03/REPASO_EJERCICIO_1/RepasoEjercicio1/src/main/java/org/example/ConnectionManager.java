package org.example;

import java.sql.*;

public class ConnectionManager {
    private static Connection conex;


    public static Connection getInstance() {
        try {
            if (conex == null) {
                Class.forName("org.h2.Driver");
                conex = DriverManager.getConnection("jdbc:h2:C:\\Users\\David\\Downloads\\bdbiblioteca\\biblioteca");
                System.out.println("Base de datos conectada:" + conex);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conex;
    }
}
