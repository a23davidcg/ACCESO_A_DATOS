package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Examen examen;
        examen = new Examen("Acceso a datos", new Date(2023, 11, 2), new ArrayList<>());

        examen.getParticipantes().add("pedro");
        examen.getParticipantes().add("Jose");
        examen.getParticipantes().add("Roberto");
        examen.getParticipantes().add("Juan");
        examen.getParticipantes().add("Alberto");

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting().create();
        gsonBuilder.serializeNulls();
        gsonBuilder.excludeFieldsWithModifiers();

        Gson  gson1 = gsonBuilder.create();
        String exameJSON = gson1.toJson(examen);

        try {
//            BufferedWriter bw = Files.newBufferedWriter(Paths.get("AccesoADatos2.json"));
            Files.writeString(Paths.get("AccesoADatos2.json"), exameJSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        BufferedReader br = null;
//        BufferedWriter bw = null;
//
//        InputStreamReader in = null;
//        FileWriter out = null;
//
//        try {
//            in = new InputStreamReader(examen);
//            br = new BufferedReader(in);
//        }






    }
}