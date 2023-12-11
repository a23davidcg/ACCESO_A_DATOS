package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class AppBiblioteca {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conex = ConnectionManager.getInstance();

        BookDAO bookDAO = new BookDAO(conex);
        Book book = new Book();


       book= bookDAO.get(10);
        System.out.println(book);
    }
}
