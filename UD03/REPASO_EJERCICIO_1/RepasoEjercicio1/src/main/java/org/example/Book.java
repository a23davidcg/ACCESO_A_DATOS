package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class Book implements Serializable {
    private Long idBook;
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private byte[] portada;

    public Book() {
    }

    public Book(String isbn, String title, String author, int year, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public Book(Long idBook, String isbn, String title, String author, int year, boolean available, byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
        this.portada = portada;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public void setPortada(Path f) {
        try {
            this.portada = Files.readAllBytes(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPortada(String f) {
        this.setPortada(Path.of(f));
    }

    public void getImage() {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(portada);
            BufferedImage bufferedImage = ImageIO.read(bis);

            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.setColor(Color.red);
            graphics2D.fillRect(0, 0, 50, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getIsbn(), book.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(title).append(author).append(year);
        return sb.toString();

    }
}
