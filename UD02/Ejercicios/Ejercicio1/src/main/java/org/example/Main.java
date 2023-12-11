package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Connection conexion = DriverManager.getConnection("jdbc:h2:D:\\DAM 2\\AD\\ACCESO_A_DATOS\\UD02\\BaseDeDatos\\biblioteca\\biblioteca.mv.db");

            //Creamos el statement
            Statement statement = conexion.createStatement();

            //ejecutamos el sql

            ResultSet resulset = statement.executeQuery("SELECT * FROM BOOK");

            //recorrer el resultset
            while (resulset.next()){
                System.out.println(resulset.getString("BOOK_PK"));
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la base de dtaos");


        }


    }
}