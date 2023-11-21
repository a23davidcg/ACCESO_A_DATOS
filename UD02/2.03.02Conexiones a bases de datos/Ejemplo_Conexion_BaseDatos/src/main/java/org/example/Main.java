package com.pepinho.ad.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {


    FileManager fileManager = FileManager.getInstance();
    FileManager file = FileManager.getInstance();

    if(file==fileManager) {
        System.out.println("Son iguais");
    } else {
        System.out.println("Son diferentes");
    }

//    ConnectionManager connectionManager = new ConnectionManager();
//        Connection connection = connectionManager.getConnection();
//
//        System.out.println(connection.getMetaData().getDatabaseProductName());
//
//        ConnectionManager con2 = new ConnectionManager();
//        Connection con = con2.getConnection();
//        System.out.println(con.getMetaData().getDatabaseProductName());

//        try {
//            Class.forName("org.h2.Driver"); // Versións previas JDBC 4.0 (JDK 1.6)
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        Connection con = DriverManager.getConnection("jdbc:h2:E:\\98 - Bases de datos\\h2\\juego\\JuegosH2.mv.db");
//
//        System.out.println(con.getMetaData().getDatabaseProductName());


    }
}