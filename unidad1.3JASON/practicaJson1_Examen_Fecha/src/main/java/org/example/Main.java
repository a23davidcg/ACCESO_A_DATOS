package org.example;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creamoos o archivo Json onde se vai a gardar os datos
        String path = "src/main/java/org/example/accesoADatos.json";
        //Creamos un objeto en java

        List<String> participantes = new ArrayList<>();
        participantes.add("Juan");
        participantes.add("Pedro");
        participantes.add("Maria");
        participantes.add("Jose");
        participantes.add("Alfredo");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Examen examen = new Examen("Examen 1","2023/11/25", participantes);



        //Crear el objeto Jsonb
        Jsonb jsonb = JsonbBuilder.create();

        //Convertir el objeto a Json
        String json = jsonb.toJson(participantes);

        //imprimir cadena JSon

        System.out.println(json);




        try (PrintWriter out = new PrintWriter (new FileWriter(path))){
            out.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
