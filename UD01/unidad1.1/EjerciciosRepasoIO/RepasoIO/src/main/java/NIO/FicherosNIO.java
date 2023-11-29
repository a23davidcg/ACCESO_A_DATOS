package NIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FicherosNIO {
    public static void main(String[] args) {
        List<String> lineas = Arrays.asList("hola", "mundo", "Desde");

        Path fichero = Paths.get("NIO.txt");

        //Para escribir en el archivo de destino una lista de strings

        try {
            Files.write(fichero, lineas, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Para leer con java nio una lista de strings de un fichero debemos de:

        Path ficheroLecrtura = Paths.get("NIO.txt");
        try {
            List<String> lineasLeidas = Files.readAllLines(ficheroLecrtura, StandardCharsets.UTF_8);
            for (String line : lineasLeidas) {
                System.out.println(line); // Para mostrar por la pantalla los String que contiene el archivo que le introducimos en el PATH
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
