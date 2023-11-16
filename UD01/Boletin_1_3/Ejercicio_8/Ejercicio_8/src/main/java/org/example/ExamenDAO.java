package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExamenDAO {

    LocalDateTimeAdapter dateTimeAdapter = new LocalDateTimeAdapter();

    public ExamenDAO(Examen examenDatos) {
    }

    public static byte[] toJson() {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        String datosJson = gson.toJson(dateTimeAdapter);

        System.out.println(datosJson);
        return new byte[0];
    }

    public static void writeToFile(){
        Path path = Paths.get("ExamenData");

        try {
            Files.write(path, toJson());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
