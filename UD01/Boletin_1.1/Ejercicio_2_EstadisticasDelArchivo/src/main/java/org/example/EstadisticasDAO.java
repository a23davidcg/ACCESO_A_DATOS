package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class EstadisticasDAO {

    public static void contadorDeLineas() {

        int contador = 0;

        try (BufferedReader br = new BufferedReader(
                new FileReader("Probas.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                contador++;

            }
            System.out.println("El numero de lineas es: " + contador);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void contadorDeEspacios() {
        int contadorEspacios = 0;
        int contadorPuntos = 0;
        try (BufferedReader br = new BufferedReader(
                new FileReader("Probas.txt"))) {

            String espacios = " ";

            while ((espacios = br.readLine()) != null) {
                for (int i = 0; i < espacios.length(); i++) {
                    if (espacios.charAt(i) == ' ') {
                        contadorEspacios++;
                    } else if (espacios.charAt(i) == '.') {
                        contadorPuntos++;
                    }
                }
            }
            System.out.println("El numero de espacioes es: " + contadorEspacios);
            System.out.println("El numero de puntos es:  " + contadorPuntos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void existe() {
        File archivo = new File("probas.txt");

        if (archivo.exists()) {
            System.out.println("El archivo existe. ");
        } else {
            System.out.println("El archivo no existe. ");
        }

    }

    public static void ultimaModificacion() {
        // Files(Paths.get("probas.txt"));
        File archivoRuta = new File("probas.txt");

        Date fechaModificacion = new Date(archivoRuta.lastModified());

        System.out.println("A ultima modificacion foi: " + fechaModificacion);
    }

    public static void getRuta() {
        File ruta = new File("probas.txt");
        String rutaComoString = String.valueOf(ruta.getAbsoluteFile());
        System.out.println("La ruta del archiv es: " + rutaComoString);

    }
}
