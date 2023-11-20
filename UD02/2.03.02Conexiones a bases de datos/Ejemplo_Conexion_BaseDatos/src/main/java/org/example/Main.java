package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        //En caso de que non teña metidos os drivers
//        try{
//            Class.forName("org.h2.Driver"); //Versions previas JDBC 4.0
//
//        }catch (ClassNotFoundException E) {
//            throw new RuntimeException(E);
//        }
//
//        //nON CONECTA PORQUE NA URL DEBERIA DE SER H3 NON SQLITE, CORREXIR ESO.
//        Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\MaquinasVirtuais\\AD\\ACCESO_A_DATOS\\ACCESO_A_DATOS\\UD02\\BaseDeDatos\\BaseDatos");
//        System.out.println(connection.getMetaData().getDatabaseProductName());

//        ConnectionManager connectionManager = new ConnectionManager();
//        Connection connection = ConnectionManager.getConnection();
//
//        System.out.println(connection.getMetaData().getDatabaseProductName());
//
//        ConnectionManager con2 = new ConnectionManager();

        FileSingleton f1 = FileSingleton.getInstance();
        FileSingleton f2 = FileSingleton.getInstance();





    }
}