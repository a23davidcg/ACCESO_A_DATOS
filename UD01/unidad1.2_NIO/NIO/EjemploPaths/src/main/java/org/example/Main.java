package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("d:\\temp\\clasificacion.dat");
        Path p2 = Paths.get("d:\\temp\\clasificacion2.dat");
        if (Files.exists(p)){
            System.out.println("el archivo existe");
            Files.copy(p, p2);
        }else {
            System.out.println("El archivo no existe");
        }

    }
}