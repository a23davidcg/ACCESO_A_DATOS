package org.example;

public class Main {
    public static void main(String[] args) {

        Documento.exists();

        Documento.readFile();

        Documento.readFileNIO();

        Documento.writeFromString();

        Documento.writeFromPrintWriter("Esto e dende printwriter");

        Documento documento = new Documento("editor.txt");
        documento.getFile();



    }
}