package Ejercicio_2;

import com.google.gson.Gson;
import org.example.Clasificacion;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lectura_Json {
    public static void main(String[] args) {
        try {
            //PAsamos el archivo  que queremos leer, pero se lo pasamos usando java nio
            String texto = new String(Files.readAllBytes(Paths.get("Clasificacion.json")));

            //Greamos el objeto Gson
            Gson gson = new Gson();

            Clasificacion clasificacion = gson.fromJson(texto, Clasificacion.class);

            System.out.println(clasificacion);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
