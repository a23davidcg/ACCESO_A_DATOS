package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        LibraryConnection libraryConnection = LibraryConnection.getInstance();

        Connection con = libraryConnection.getConnection();

        if (con == null) {
            System.out.println("conexion establecida");
        }else {
            System.out.println("non se puido conectar coa base de datos. ");
        }

        //TODO: QUEDA POR FACER O TRY CATCH

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from");

        while (rs.next()) {
            System.out.println(rs.getString("tittle"));
        }
    }
}