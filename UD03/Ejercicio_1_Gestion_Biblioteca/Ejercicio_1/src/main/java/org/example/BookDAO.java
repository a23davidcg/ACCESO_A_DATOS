package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {


    @Override
    public Book get(Long id) {
        try ( Connection conexion = ConnectionManager.getInstance();
              PreparedStatement ps = conexion.prepareStatement("SELECT * FROM Book WHERE idBook = ?");){


            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

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

            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Book> getAll() {

        List<Book> books = new ArrayList<>();
        try (Connection conexion = ConnectionManager.getInstance();
             Statement st = conexion.createStatement();){


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

            return books;//devolvemos dentro do try para que en caso de fallar o metodo poder devolver unha lista vacia

        } catch (SQLException e) {
            return new ArrayList<>();
        }

    }

    @Override
    public void save(Book book) {


        String isbn = book.getIsbn();
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getYear();
        boolean available = book.isAvailable();


        try (  Connection conexion = ConnectionManager.getInstance();
               PreparedStatement pst = conexion.prepareStatement("INSERT INTO Book ('isbn', 'title', 'author', 'year', 'available' ) VALUES (?,?,?,?,?);");){


            pst.setString(1, isbn);
            pst.setString(2, title);
            pst.setString(3, author);
            pst.setInt(4, year);
            pst.setBoolean(5, available);


            pst.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error ao facer a insercion na base de datos");
        }
    }

    @Override
    public void update(Book book) {

        try {
            Connection conexion = ConnectionManager.getInstance();
            PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET isbn = ?, title = ?, author = ?, year =?, available =? WHERE idBook = ?; ");

            pst.setString(1, book.getIsbn());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setInt(4, book.getYear());
            pst.setBoolean(5, book.isAvailable());

            pst.executeUpdate();

            //Solo actualizamos os parametros qeu non se generan de forma automatica ou nunca son nulos an base de datos.



        } catch (SQLException e) {
            System.err.println("Non se puido actualizar a columna na base de datos. ");
        }


    }

    @Override
    public void delete(Book book) {
        Long idBook = book.getIdBook();
        this.deleteById(idBook);


    }

    @Override
    public void deleteById(long id) {
        try (Connection conexion = ConnectionManager.getInstance();
             PreparedStatement pst = conexion.prepareStatement("DELETE FROM Book WHERE idBook = ?; ");) {

            pst.setLong(1, id);

            pst.execute();

        } catch (SQLException e) {
            System.err.println("Non se puideron borrar as insercions da base de datos. ");
        }


    }

    @Override
    public void updateImage(Book book, String f) {

        book.setPortada(f);
        byte[] portadaLibro = book.getPortada();

        try (Connection conexion = ConnectionManager.getInstance();
        PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET Portada=? ; ")){
            pst.setBytes(1, portadaLibro);
        }catch (SQLException e){
            System.err.println("Non se puido actualizar a portada do libro.");
        }



    }

    @Override
    public void updateImageById(long id, String f) {

        byte[] portadaActualizar = f.getBytes();

        try (Connection conexion = ConnectionManager.getInstance();
             PreparedStatement pst = conexion.prepareStatement("UPDATE Book SET Portada= ? WHERE idBook=?; ");) {
            pst.setBytes(1, portadaActualizar);
            pst.setLong(2, id);

            pst.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Non se puido actulizar a portada mediante id");

        }


    }


    //
    //
    //
    //    @Override
    //    public void updateImageById(long id, String f) {
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
    //}

    @Override
    public void deleteAll() {
        try (Connection conexion = ConnectionManager.getInstance();
        PreparedStatement pst = conexion.prepareStatement("DELETE FROM Book ")){
            pst.execute();
        }catch (SQLException e){
            System.err.println("Non se puido borrar a base de datos. ");
        }

    }
}
