package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Programa que liste los archivos de un directorio, por medio del metodo list(). debe de mostrrar
        // solo los archvios de fuente java, no los directorios que contiene, recuerda el uso de filtros Stream y foreach

        String directorio = "D:\\MaquinasVirtuais\\AD\\unidad1.1\\";

        listFiles(Paths.get(directorio));


    }

    public static void listFiles(Path ruta) {
        if(Files.isDirectory(ruta)){
            try(Stream<Path> s = Files.list(ruta)) {
                s.filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(".java"))
                        .forEach(System.out::println);
            } catch (IOException e) {
               System.out.println(e.getMessage());
            }
        }

    }
}