package Ejercicio_8_Examen_LocalDate_Serializer_Deserializer;

import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Examen examen = new Examen("Acceso a Datos",
                LocalDateTime.of(2023, 11, 12, 9, 30),
                List.of("Gabriela Mistral",
                        "Silviana Ocampo",
                        "Juana Conde",
                        "Clara Campoamor"));
        System.out.println(examen);


    }

    private static void saveExamenToJson(Examen examen, String NombreArchivo) {

        String examenSave = "examenFecha.json";
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class,
                        new JsonDeserializer<LocalDateTime>() {
                            public JsonElement serialize(LocalDateTime fecha, Type type, JsonDeserializationContext) {
                                JsonArray array = new JsonArray();
                                array.add(fecha.getYear());
                                array.add(fecha.getMonthValue());
                                array.add(fecha.getDayOfMonth());
                                return array;
                            }
                        })
                .create();

        String examenJson = gson.toJson(examen);

        try (BufferedWriter bw = new BufferedWriter(Paths.get(examenSave));) {
            gson.toJson(examen, bw);

        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    private static void showFile(String nombreArchivo) {
        try {
            String read = Files.readString(Path.of(nombreArchivo));
            System.out.println("Contenido del archivo: "
                    + nombreArchivo + "JSON" + System.lineSeparator() + contenido);

        } catch (IOException e) {
            System.out.println("ERROR ES:" + e.getMessage());
        }
    }

    public static Examen getExamenFromJson(String nombreArchivo) {
        var gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    public LocalDateTime deserialize(JsonElement je, Type typeOFT, JsonDeserializationContext) throws JsonParseException {
                        LocalDateTime fecha = LocalDateTime.now();
                        String strFecha = je.getAsString();

                        String[] campos = strFecha.split(" ");

                        System.out.println(campos[0]);
                        System.out.println(campos[1]);

                        return fecha;
                    }
                }).create();

        try {
            String examenJSON = Files.readString(Path.of(nombreArchivo));
            return gson.fromJson(examenJSON, Examen.class);

        } catch (IOException e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return null;

    }
}
