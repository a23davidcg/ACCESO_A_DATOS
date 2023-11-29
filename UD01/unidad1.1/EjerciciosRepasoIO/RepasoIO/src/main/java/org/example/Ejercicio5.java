package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        /*Crea un metodo que reciba una carpeta y liste el contenido de dicha carpeta de aquellos archivos cuya extension sea .txt. Crea
         * una sobrecarga [ara que el metodo reciba el tipo de archivo a listar
         *
         * Crea un metodo que debe de crear n archivos, nombre(1).txt, nombre(2).txt, dentro de la carpeta que solicita el usuario. Dentro de cada archivo debe de escribirse
         * el nombre del fichero en que se escribe la frase, "El nombre del fichero es:"*/

        //File carpeta = new File();

        cantiodadPalabras("destino.txt", "copia");

    }

    public static void cantiodadPalabras(String nombreArchivo, String palabraBuscada) {
        int contador = 0; //Se ira auamentado a medida que aparecen las palabras dentro del archivo
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(nombreArchivo));

            Scanner sc = new Scanner(br);

            while (sc.hasNextLine()) {
                String[] palabraslineas = sc.nextLine().split("\\s+");
                for (String palabraActual : palabraslineas) {
                    if (palabraActual.equals(palabraBuscada)) {
                        contador++;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Non se pode acceder ao archivo para leer as palabras del e contalas. ");
        }
        System.out.println("La palabra: " + palabraBuscada.toUpperCase() + ", aparece " + contador + " veces en el archivo.");
    }
}
