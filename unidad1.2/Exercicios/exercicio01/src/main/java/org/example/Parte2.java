package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parte2 {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("D:\\MaquinasVirtuais\\AD\\unidad1.2\\Exercicios\\exercicio01\\proba.dat");
        Path p2 = Paths.get("D:\\MaquinasVirtuais\\AD\\unidad1.2\\Exercicios\\exercicio01\\proba2.dat");
        Path p3;

        if (Files.exists(p2)) {
            System.out.println("El archivo existe, se va a copiar al otro ya existente");
            Files.delete(p2);
            Files.copy(p1, p2);

        } else {
            System.out.println("El archivo 2 no existe, se va a crear uno nuevo en vez de borrar el ya existente");
            Files.copy(p1,p2);

        }



    }
}
