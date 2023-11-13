package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Clasificacion clasificacion = new Clasificacion("Real Madrid", 4, 4, 0, 374, 311, 63);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String resultado = gson.toJson(clasificacion);


        /*try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("clasificacion.json"))) {

            bw.write(resultado);
            System.out.println(resultado);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        /*try {
            String resultado1 = gson.toJson(clasificacion);

            Path path = Path.of("clasificacion.json");

            Files.writeString(path, resultado1);
            System.out.println("Este es el resultado de la clasificacion para ser pasada al archivo json \n" + resultado1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        Path pathFile = Paths.get("clasificacion.json");

        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(pathFile, StandardOpenOption.WRITE, StandardOpenOption.CREATE ))){
            oos.writeObject(resultado);
            System.out.println("objeto escrito con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}