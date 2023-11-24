package org.example;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Escribe un programa en Java que copie el contenido de un archivo llamado "origen.txt" a otro archivo llamado "destino.txt".

        String origen = "origen.txt";
        String destino = "destino.txt";

        try (BufferedReader reader = new BufferedReader(
                new FileReader(origen))) {

            String contenido;

            while ((contenido = reader.readLine()) != null) {
                System.out.println("El contenido que se lee es: " + contenido);

                try (BufferedWriter bw = new BufferedWriter(
                        new FileWriter(destino, true))) {

                    bw.append(contenido + "º\n Se ha añadido esto desde el archivo de origen para hacer un copia pega desde el origen hasta el destino");
                }
            }

        } catch (IOException e) {
        }
    }
}
