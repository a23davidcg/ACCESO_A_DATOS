package org.example;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Escribe un programa en Java que copie el contenido de un archivo llamado "origen.txt" a otro archivo llamado "destino.txt".

        String origen = "origen.txt";
        File destino = new File ("destino.txt");

        try (BufferedReader reader = new BufferedReader(
                new FileReader(origen))) {
            int caracter;
            while ((caracter = reader.read()) != -1){
                System.out.println((char) caracter);

            }

            String contenido;

            while ((contenido = reader.readLine()) != null) {
                System.out.println("El contenido que se lee es: " + contenido);

                try (BufferedWriter bw = new BufferedWriter(
                        new FileWriter(destino, true))) {
                    if (!destino.exists()){
                        System.out.println("El archivo no existe, por lo quye se va a crear uno nuevo");
                        destino.createNewFile();
                    }else {
                        System.out.println("El archivo existe");
                    }

                    bw.append(contenido + "º\n Se ha añadido esto desde el archivo de origen para hacer un copia pega desde el origen hasta el destino");
                }
            }

        } catch (IOException e) {
        }
    }
}
