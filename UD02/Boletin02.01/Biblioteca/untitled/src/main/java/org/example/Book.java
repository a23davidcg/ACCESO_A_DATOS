package org.example;

import java.io.Serializable;
import java.nio.file.Path;

public class Book implements Serializable {
    private long idBook;
    private String isbn;
    private String title;
    private String author;
    private int year;
    private Boolean available;
    private Byte[] portada;

    public Book() {
    }

    public Book(String isbn, String title, String author, int year, Boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public Book(long idBook, String isbn, String title, String author, int year, Boolean available, Byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
        this.portada = portada;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Byte[] getPortada() {
        return portada;
    }

    public void setPortada(Byte[] portada) {
        this.portada = portada;
    }

    public void setPortada(Path f) {

    }

    public void setPortada(String f) {

    }

    public void getImage() {

    }
}
