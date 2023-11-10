package Ejercicio_1_CGPT;

import com.solidfire.gson.Gson;
import com.solidfire.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Albertino", 20, new String[] {"Matematicas", "Literatura", "Fisica", "Quimica"});

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Creamos el gson pero con formato gracias al prettyprinting

        String jsonEstudiante = gson.toJson(estudiante);

        System.out.println(jsonEstudiante);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter ("pruebasJson.json"))){
            bw.write(jsonEstudiante);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}