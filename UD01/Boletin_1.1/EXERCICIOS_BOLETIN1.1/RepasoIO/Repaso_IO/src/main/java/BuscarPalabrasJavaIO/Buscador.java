package BuscarPalabrasJavaIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Buscador {

    public static void buscarPAlabra() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("ProbasExercicioDestino.txt"))) {

            String linea;
            String palabraBuscada = "hola";
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+ "); //Se usa para buscar coincidencias con uno o mas espacios en blanco

                for (String palabra : palabras) {
                    if (palabraBuscada.equalsIgnoreCase(palabraBuscada)) {
                        contador++;
                    }

                }
            }
            System.out.println(contador);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void buscarPAlabraStreams() {
        try (BufferedInputStream br = new BufferedInputStream(
                new FileInputStream("ProbasExercicioDestino.txt"))) {

            int resultado;
            String palabraBuscada = "hola";
            int contador = 0;
            byte[] arrayDeBytes = new byte[1000];
            while ((resultado = br.read(arrayDeBytes, 0, 1000)) != -1) {
                String linea = new String(arrayDeBytes);

                String[] palabras = linea.split("\\s+ "); //Se usa para buscar coincidencias con uno o mas espacios en blanco

                for (String palabra : palabras) {
                    if (palabraBuscada.equalsIgnoreCase(palabraBuscada)) ;
                    contador++;
                }
            }
            System.out.println(contador);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        public static void buscarPAlabraStreams2 () {
            String palabraBuscada = "hola";
            int contador = 0;
            try {

                List<String> lineas = Files.readAllLines(Path.of("ProbasExercicioDestino.txt"));
                for (String linea : lineas) {
                    String[] palabras = linea.split("\\s+ "); //Se usa para buscar coincidencias con uno o mas espacios en blanco

                    for (String palabra : palabras) {
                        if (palabraBuscada.equalsIgnoreCase(palabraBuscada)) ;
                        contador++;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

