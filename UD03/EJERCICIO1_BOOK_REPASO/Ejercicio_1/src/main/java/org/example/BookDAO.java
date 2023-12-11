package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IDAO<Book> {

    private Connection conexion;

    public BookDAO() {

    }

    @Override
    public Book get(long id) {
        try (PreparedStatement pst = conexion.prepareStatement("SELECT * FROM Book WHERE idBook=?;", Statement.RETURN_GENERATED_KEYS)) {

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

                Book book = new Book(idBook, isbn, title, author, year, available, portada);
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Book> getAll() {

        List<Book> books = new ArrayList<>();

        try (Statement st = conexion.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Book");


            while (rs.next()) {


                String isbn = rs.getString(2);
                String title = rs.getString(3);
                String author = rs.getString(4);
                int year = rs.getInt(5);
                boolean available = rs.getBoolean(6);


                Book book = new Book(isbn, title, author, year, available);
                books.add(book);

            }

        } catch (SQLException e) {
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
        boolean available = book.isAvailable();

        try (PreparedStatement pst = conexion.prepareStatement("INSERT INTO Book ('isbn', 'title', 'author', 'year', 'available') VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, isbn);
            pst.setString(2, title);
            pst.setString(3, author);
            pst.setInt(4, year);
            pst.setBoolean(5, available);

            pst.executeUpdate();


            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()) {
                book.setIdBook(rs.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Book book) {
        Long idBook = book.getIdBook();
        try (PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET isbn=?, title= ?, author=?, year=?, available=?   WHERE idBook = ?")) {

            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setInt(4, book.getYear());
            pst.setBoolean(5, book.isAvailable());
            pst.setLong(6, idBook);

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Book book) {

        this.deleteById(book.getIdBook());

    }

    @Override
    public void deleteById(long id) {

        try (PreparedStatement pst = conexion.prepareStatement("DELETE FROM Book WHERE idBook=?;")) {
            pst.setLong(1, id);

            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateImage(Book book, String f) {
        byte[] imagenPortada = f.getBytes();

        try (PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET portada=? WHERE idBook=?;")){

            pst.setBytes(1, imagenPortada);
            pst.setLong(2, book.getIdBook());

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //
        //        try (Connection conexion = ConnectionManager.getInstance();
        //             PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET Portada = ? WHERE idBook = ?")) {
        //
        //            // Convert the image string to bytes
        //            byte[] portadaActualizar = f.getBytes();
        //
        //            // Create a ByteArrayInputStream from the byte array
        //            ByteArrayInputStream inputStream = new ByteArrayInputStream(portadaActualizar);
        //
        //            // Set the BLOB parameter in the prepared statement
        //            pst.setBlob(1, inputStream);
        //            // Set the book ID as a parameter in the prepared statement
        //            pst.setLong(2, id);
        //
        //            // Execute the update query
        //            pst.executeUpdate();
        //
        //        } catch (SQLException e) {
        //            // Handle SQLException
        //            System.err.println("No se pudo actualizar la portada mediante id");
        //        }
        //    }


    }

    @Override
    public void updateImageById(long id, String f) {

        Book book = this.get(id);
        book.setPortada(f);
        byte[] portadaActualizar = book.getPortada();

        try(PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET portada=? WHERE idBook=?;")){

            pst.setBytes(1, portadaActualizar);
            pst.setLong(2, id);

            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteAll() {

        try(PreparedStatement pst = conexion.prepareStatement("DELETE * FROM Book ")){
            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
