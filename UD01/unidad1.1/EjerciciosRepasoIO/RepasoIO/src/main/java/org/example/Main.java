package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //Escribe un programa en Java que cree un archivo de texto llamado "output.txt" y escriba en él la cadena "Hola, mundo!".

        String directorio = "Prueba.txt";


        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(directorio, true))) {

            br.newLine();
            br.append("Hola mundo! ");

        } catch (IOException e) {
            System.err.println("non se puido crear o archivo");
        }


        try(BufferedReader br = new BufferedReader(new FileReader(directorio))){

            String contenido;

            while ((contenido = br.readLine())!= null){
                br.readLine();

                System.out.println("El contenido del txt es:  " + contenido);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}