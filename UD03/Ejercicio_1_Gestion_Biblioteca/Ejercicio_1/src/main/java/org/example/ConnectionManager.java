package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //Gestion de conexiones con la base de datos
    //Mediante el paatron singleton debemos de

    private static Connection conex;

    public static Connection getInstance() throws SQLException {
        if (conex== null){
            System.out.println("conectada a base de datos");
            conex = DriverManager.getConnection("jdbc:h2:C:\\Users\\David\\Downloads\\bdbiblioteca\\biblioteca.mv.db");

        }
        return conex;
    }

}
