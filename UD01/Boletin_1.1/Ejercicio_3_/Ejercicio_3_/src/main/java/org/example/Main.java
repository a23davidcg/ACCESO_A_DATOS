package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Documento documento = new Documento("documento ");

        documento.exists();
        documento.writeFromString();

        documento.writeFromStringPrintWriter("Esto se ha añadido a mayores de lo ya escrito por el anterior metodo ");



    }
}