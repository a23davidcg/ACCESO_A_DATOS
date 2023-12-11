package com.pepinho.programacion.boletin10;

import java.sql.*;
import java.util.Scanner;

public class AppLibrary {
    public static void main(String[] args) {

        ConnectionLibrary connectionLibrary = ConnectionLibrary.getInstance();

        Connection con = connectionLibrary.getConnection();

        // Ejemplo de cómo emplear supportsResultSetType y supportsResultSetConcurrency
        // para comprobar si el driver soporta el tipo de ResultSet que queremos emplear


//        Scanner sc = new Scanner(System.in);
//        System.out.println("Introduzca el título del libro a buscar: ");
//        String titulo = sc.nextLine();

//        if(con!=null){
//            try(PreparedStatement ps = con.prepareStatement("INSERT INTO PUBLIC.Book (isbn, title, author, ano, " +
//                    "available) VALUES (?, ?, ?, ?, ?);")){
//                ps.setString(1, "9780307959474");
//                ps.setString(2, "El Sentido de un Final");
//                ps.setString(3, "Julian Barnes");
//                ps.setInt(4, 2011);
//                ps.setBoolean(5, true);
//                int insertadas = ps.executeUpdate();
//                System.out.println("insertadas " + insertadas);
//
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }

        if (con != null) {
            try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
                 ResultSet rs = st.executeQuery("SELECT * FROM Book");) {


                while (rs.next()) {
                    System.out.printf("%d - %s%n", rs.getInt("idBook"), rs.getString("title"));
                }


            } catch (SQLException ex) {
                System.out.println("Error al obtener libro: " + ex.getMessage());
            }
        }


//
//        BookDAO bookDAO = new BookDAO(connectionLibrary.getConnection());
//
//
//
//        new BibliotecaViewDAO("Biblioteca", bookDAO);
    }

    public static void admiteRetencion(Connection conn) throws SQLException {

        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println("ResultSet.HOLD_CURSORS_OVER_COMMIT = " +
                ResultSet.HOLD_CURSORS_OVER_COMMIT);
        System.out.println("ResultSet.CLOSE_CURSORS_AT_COMMIT = " +
                ResultSet.CLOSE_CURSORS_AT_COMMIT);
        System.out.println("Retención predeterminada del cursor: " +
                dbMetaData.getResultSetHoldability());
        System.out.println("¿Admite HOLD_CURSORS_OVER_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.HOLD_CURSORS_OVER_COMMIT));
        System.out.println("¿Admite CLOSE_CURSORS_AT_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.CLOSE_CURSORS_AT_COMMIT));
        try {
            if (conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Soporta TYPE_SCROLL_INSENSITIVE");
            } else {
                System.out.println("No soporta TYPE_SCROLL_INSENSITIVE");
            }
            if (conn.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                System.out.println("Soporta CONCUR_UPDATABLE");
            } else {
                System.out.println("No soporta CONCUR_UPDATABLE");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener metadatos: " + ex.getMessage());
        }

        if (conn != null) {
            System.out.println("Conexión establecida");
        } else {
            System.out.println("Conexión no establecida");
        }
    }


}
