package org.example;

public class AppBiblioteca {
    public static void main(String[] args) {
        ConnectionManager conex = new ConnectionManager();

        BookDAO bookDAO = new BookDAO();

        Book libros = bookDAO.get(1L);

        System.out.println(libros);
    }



}
