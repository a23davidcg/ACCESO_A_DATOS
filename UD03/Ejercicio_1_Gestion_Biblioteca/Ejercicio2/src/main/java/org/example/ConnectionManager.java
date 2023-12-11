package org.example;

import java.sql.*;

public class ConnectionManager {
    private static Connection conex;

    public static Connection getInstance() throws SQLException, ClassNotFoundException {

        try {
            if (conex == null) {
                Class.forName("org.h2.Driver");
                conex = DriverManager.getConnection("jdbc:h2:C:\\Users\\David\\Downloads\\bdbiblioteca\\biblioteca.mv.db");

                System.out.println(conex);
                System.out.println("Base de datos conectada.");
            }

            try (PreparedStatement st = conex.prepareStatement("SHOW TABLES;");) {

                ResultSet rs = st.executeQuery();

                System.out.println(rs.toString()+ "TABLAS");

                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
            return conex;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
