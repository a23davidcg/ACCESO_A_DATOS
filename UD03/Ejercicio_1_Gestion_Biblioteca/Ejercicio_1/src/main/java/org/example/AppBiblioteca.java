package org.example;

public class AppBiblioteca {
    public static void main(String[] args) {
        Book libro = new Book("9788424937744", "Tractatus logico-philosophicus-"
                + "investigaciones filosóficas", "Ludwig Wittgenstein", 2017, false);

        libro = new Book("9788499088150", "Verano", "J. M. Coetzee", 2011, true);



        BookDAO bookDAO = new BookDAO();

        bookDAO.save(libro);


    }


}
