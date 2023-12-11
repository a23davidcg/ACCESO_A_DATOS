package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {

    private Connection conexion ;

    public BookDAO() {
        this.conexion = ConnectionManager.getInstance();
    }

    @Override
    public Book get(Long id) {
        try (PreparedStatement pst = conexion.prepareStatement("SELECT * FROM \"Book\" WHERE \"idBook\"=?")) {

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
            System.err.println("Non se puido facer a lectura de toda a base de datos no metodo get" + e);
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try (Statement st = conexion.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT * FROM book;");

            while (rs.next()) {

                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                int year = rs.getInt(4);
                boolean available = rs.getBoolean(5);


                Book book = new Book(isbn, title, author, year, available);
                books.add(book);
            }
        } catch (SQLException E) {
            System.err.println("non se puido engadir o libro a lista");
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

            //FIXME: REVISAR

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()){
                book.setIdBook(rs.getLong(1));
            }

        } catch (SQLException e) {
            System.err.println("Non se puido gardar o libro na base de datos.");
        }
    }

    @Override
    public void update(Book book) {

        Long id = book.getIdBook();
        try (PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET isbn=?, title= ?, author=?, year=?, available=?  WHERE idBook=?;")) {
            pst.setLong(6, id);
            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setInt(4, book.getYear());
            pst.setBoolean(5, book.isAvailable());


            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Non se puido actualizar o elemento da base de datos. ");

        }

    }

    @Override
    public void delete(Book book) {
        Long idBook = book.getIdBook();
        this.deleteById(idBook);

    }

    @Override
    public void deleteById(Long id) {
        try (PreparedStatement pst = conexion.prepareStatement("DELETE FROM Book WHERE idBook =?;")) {

            pst.setLong(1, id);

            pst.execute();

        } catch (SQLException e) {
            System.err.println("non se puido borrar o elemento");
        }
    }

    @Override
    public void updateImage(Book book, String f) {
        byte[] imagenPortada = f.getBytes();

        try (PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET portada=? WHERE idBook=?;")) {

            pst.setBytes(1, imagenPortada);
            pst.setLong(2, book.getIdBook());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Non se pode actualizar a imaxe da base de datos. ");
        }
    }

    @Override
    public void updateImageById(Long id, String f) {

        Book book = this.get(id);
        book.setPortada(f);
        byte[] portadaActualizar = book.getPortada();


        try (PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET portada=? WHERE idBook=?;")) {
            pst.setBytes(1, portadaActualizar);
            pst.setLong(2, id);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Non se puido actualizar a imaxen que se solicita por id no paramtero do metodo. ");

        }
    }

    @Override
    public void deleteAll() {
        try (PreparedStatement pst = conexion.prepareStatement("DELETE * FROM Book;")) {

            pst.execute();

        } catch (SQLException e) {
            System.err.println("Non foi posible proceder ao borrado da base de datos. ");
        }
    }
}
