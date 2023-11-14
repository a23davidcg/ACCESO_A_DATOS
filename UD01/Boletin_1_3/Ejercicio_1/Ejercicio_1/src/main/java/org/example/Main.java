package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Clasificacion clasificacion = new Clasificacion("Real Madrid", 4, 4, 0, 374, 311, 63);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();



        Path pathFile = Paths.get("clasificacion.json");
        Pa

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(pathFile)));){


    }
}