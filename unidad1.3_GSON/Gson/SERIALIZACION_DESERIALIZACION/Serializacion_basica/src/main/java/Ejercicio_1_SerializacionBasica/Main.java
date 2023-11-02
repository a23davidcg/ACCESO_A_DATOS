package Ejercicio_1_SerializacionBasica;

//Objetivo es serialixzar un objeto simple en formato json
//Crea una clase persona, con los atributos nombre, edad y ciudad, luego crea una instancia de esa clase, conviertela en json y muestra el json resultante en la consola


//A mayopres se ha creado un archivo json con formato, en el cual se ha escrito la informacion de la classe persona


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) {

        Persona persona = new Persona("Iria", 23, "Santiago de Compostela");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(persona);
        //Gson gson = new Gson();
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("Persona.json"))) {
            bw.flush();
            bw.write(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}