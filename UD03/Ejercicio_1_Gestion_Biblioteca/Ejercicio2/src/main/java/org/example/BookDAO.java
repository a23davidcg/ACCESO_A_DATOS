package org.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {
    private final Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;

    }

    @Override
    public Book get(long id) {
        System.out.println("METODO GET ");


        try (PreparedStatement pst = this.connection.prepareStatement("SELECT * FROM PUBLIC.\"Book\"  WHERE idBook=?;")) {

            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Long idBook = rs.getLong(1);
                String isbn = rs.getString(2);
                String title = rs.getString(3);
                String author = rs.getString(4);
                int year = rs.getInt(5);
                boolean available = rs.getBoolean(6);
                byte[] portada = rs.getBytes(7);

                System.out.println(idBook + isbn);


                return new Book(idBook, isbn, title, author, year, available, portada);
            } else {
                return null;
            }


        } catch (SQLException e) {
            System.err.println("non se encontra a tabla na base de datos");
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Book> getAll() {
        // implements a method to get all books from database and return a list of books
        List<Book> books = new ArrayList<>();
        try (Connection conexion = ConnectionManager.getInstance();
             Statement st = conexion.createStatement()) {


            ResultSet rs = st.executeQuery("SELECT * FROM Book; ");

            while (rs.next()) {
                Long idBook = rs.getLong(1);
                String isbn = rs.getString(2);
                String title = rs.getString(3);
                String author = rs.getString(4);
                int year = rs.getInt(5);
                boolean available = rs.getBoolean(6);
                byte[] portada = rs.getBytes(7);

                Book book = new Book(idBook, isbn, title, author, year, available, portada);

                books.add(book);
            }

        } catch (SQLException e) {
            System.err.println("non se encontra a tabla na base de datos");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public void save(Book book) {

        String isbn = book.getIsbn();
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getYear();
        boolean isavailable = book.isAvailable();

        try (Connection conexion = ConnectionManager.getInstance();
             PreparedStatement pst = conexion.prepareStatement("INSERT INTO Book ('isbn', 'title', 'author', 'year', 'isavailable') VALUES (?,?,?,?,?);")) {

            pst.setString(1, isbn);
            pst.setString(2, title);
            pst.setString(3, author);
            pst.setInt(4, year);
            pst.setBoolean(5, isavailable);

            pst.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Non se puido facer a insercion na base de datos" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book) {
        try (Connection conex = ConnectionManager.getInstance();
             PreparedStatement pst = conex.prepareStatement("UPDATE Book SET isbn =?, title=?, author=?, year =?, available=?; ")) {

            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setInt(4, book.getYear());
            pst.setBoolean(5, book.isAvailable());

            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Non se puideron actualizar os valores da base de datos ");
        }
    }

    @Override
    public void delete(Book book) {
        Long id = book.getIdBook();
        this.deleteById(id);


    }

    @Override
    public void deleteById(long id) {

        try (Connection conexion = ConnectionManager.getInstance();
             PreparedStatement pst = conexion.prepareStatement("DELETE FROM Book WHERE idBook=?;")) {

            pst.setLong(1, id);

            pst.execute();
        } catch (SQLException exception) {
            System.err.println("Non foi posible borrar mediante a ID que se pasou como parametro do metodo");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateImage(Book book, String f) {
        //ALternativa con blop ou clop no caso de ser un texto moi largo

        try (Connection conex = ConnectionManager.getInstance();
             PreparedStatement pst = conex.prepareStatement("UPDATE Book SET Portada=? WHERE idBook=?;")) {

            byte[] fileContent = Files.readAllBytes(Path.of(f)); //Leemos a imaxe que se quere engadir a base de datos como un blop que nos permite meter bytes de gran tamañp

            ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContent);//metemos o que leemos nun stream que posteriormente ese stream sera o que se escriba na base de datos

            pst.setBlob(1, inputStream);
            pst.setLong(2, book.getIdBook());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Non foi posible actualizar na base de datos");
        } catch (IOException e) {
            System.err.println("ERRO ao intentar leer a imaxe que se quere engadir a base de datos. ");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao establecer a conexion coa base de datos no metodo UPDATEIMAGE");
        }


//        book.setPortada(f);
//        byte[] portadaLibro = book.getPortada();
//
//        try (Connection conexion = ConnectionManager.getInstance();
//             PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET portada=?; ")) {
//
//            pst.setBytes(1, portadaLibro);
//
//            pst.executeUpdate();
//
//        } catch (SQLException e) {
//            System.err.println("Non se puido actualizar a imaxen na base de datos.");
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Override
    public void updateImageById(long id, String f) {
        byte[] portada = f.getBytes();

        try (Connection conexion = ConnectionManager.getInstance();
             PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET portada=? WHERE idBook=?")) {

            pst.setBytes(1, portada);
            pst.setLong(2, id);

            pst.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Non se puido actualizar a base de datos pola id que se introduciu como parametro do método. ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAll() {

        try (Connection conexion = ConnectionManager.getInstance();
             PreparedStatement pst = conexion.prepareStatement("DELETE FROM Book; ")) {
            pst.execute();

        } catch (SQLException e) {
            System.err.println("Non foi posible borrar a base de datos. ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
