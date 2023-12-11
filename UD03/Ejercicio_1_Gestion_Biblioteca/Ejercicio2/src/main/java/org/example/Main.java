package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conexion = ConnectionManager.getInstance();

        BookDAO bookDAO = new BookDAO(conexion);
        String getBook = String.valueOf(bookDAO.get(2));
        System.out.println(getBook);

    }
}