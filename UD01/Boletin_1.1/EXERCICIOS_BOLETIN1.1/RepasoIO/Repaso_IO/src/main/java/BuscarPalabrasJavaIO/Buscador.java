package BuscarPalabrasJavaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
                    if (palabraBuscada.equalsIgnoreCase(palabraBuscada)) ;
                    contador++;
                }
            }
            System.out.println(contador);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

