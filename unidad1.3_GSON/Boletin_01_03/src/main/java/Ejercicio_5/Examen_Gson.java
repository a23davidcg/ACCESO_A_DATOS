package Ejercicio_5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Examen_Gson {
    public static void main(String[] args) {

        List<String> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add("Pepe");
        listaEstudiantes.add("Gonzalo");
        listaEstudiantes.add("Alberto");

        Date fecha = new Date();


        Examen_1 examen = new Examen_1("Acceso a Datos", fecha, listaEstudiantes);


        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy/mm/dd")
                .create();
        try {

            String jsonExamen = gson.toJson(examen);
            BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(Paths.get("ExamenConDate.json"))));
            bw.write(jsonExamen);
            bw.close();

            System.out.println(examen);

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
