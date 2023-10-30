package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Clasificacion clasificacion = new Clasificacion("Barcelona", 2, 4, 45, 230, 150);

        //Creamos el objeto gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String clasi = gson.toJson(clasificacion); //PAra poder pasarlo al formato de json

        //Creamos el archivo para poder escribir en el con formato bonito.
        try {
            FileWriter fw = new FileWriter(String.valueOf(Paths.get("Clasificacion.json")));
            fw.write(clasi);
            System.out.println("Ärchivo creado correctamente. ");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}