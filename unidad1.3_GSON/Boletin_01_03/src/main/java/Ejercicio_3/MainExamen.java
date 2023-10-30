package Ejercicio_3;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class MainExamen {
    public static void main(String[] args) {


        Examen examen = new Examen("Matemáticas", LocalDateTime.now()/*.of(2023, 11, 3, 15, 25)*/, List.of("Estudiante 1", "Estudiante 2", "Estudiante 3"));

        System.out.println(examen);


        //pasamos los datos del examen a un json
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("Anio" , examen.getFecha().getYear());
                jsonObject.addProperty("Mes" , examen.getFecha().getMonthValue());
                jsonObject.addProperty("Dia" , examen.getFecha().getDayOfMonth());
                return  jsonObject;
            }
        }).create();
        //Para guardarlo en un archivo json:
        String dato = gson.toJson(examen);


        try {
            FileWriter fw = new FileWriter(String.valueOf(Paths.get("DatosExamen.json")));
            fw.write(dato);
            System.out.println("Escribironse os datos de forma corecta");
            fw.close();
        } catch (IOException e) {
            System.err.println("Error ao imprimir os datos do examen no archivo json");
        }
    }
}

