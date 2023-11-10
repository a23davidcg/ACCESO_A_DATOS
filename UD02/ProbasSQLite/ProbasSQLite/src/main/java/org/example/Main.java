package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection conection = DriverManager.getConnection("jdbc:sqLite:D:\\MaquinasVirtuais\\AD\\ACCESO_A_DATOS\\ACCESO_A_DATOS\\UD02\\BaseDeDatos\\BaseDatos");
             Statement st = conection.createStatement();) {

            ResultSet rs = st.executeQuery("SELECT * FROM animal");

            System.out.println("Conexion a base de datos ");
            while (rs.next()) {
                String nombre = rs.getString("nome");
                String nomePorIndice = rs.getString(1);
                String dataNacemento = rs.getString("dataNacemento");
                int especie = rs.getInt("idEspecie");


                System.out.printf("%10s %20s %d%n", nombre, dataNacemento, especie);

            }
        } catch (SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
            e.printStackTrace();
        }
    }
}