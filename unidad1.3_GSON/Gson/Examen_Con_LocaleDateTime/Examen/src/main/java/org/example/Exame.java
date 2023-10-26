/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;


import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.time.LocalDateTime;

import java.util.List;


public class Exame {

    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Exame() {
        // Constructor vacío necesario para JSON-B
    }

    public Exame(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    // Métodos getter y setter
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Materia: ").append(materia)
                .append("\nFecha: ").append(fecha)
                .append("\nParticipantes: ").append(participantes);
        return sb.toString();
    }

    public static void main(String[] args) {

        // Crear exame
        Exame exame = new Exame("Acceso a Datos",
                LocalDateTime.of(2023, 11, 12, 9, 45),
                List.of("Gabriela Mistral",
                        "Silvina Ocampo",
                        "Juana de Ibarbourou",
                        "Carmen Conde",
                        "Claribel Alegría"));

        System.out.println(exame);

        // Convertir exame a JSON y guardarlo en un archivo
        saveExamToJSON(exame, "e:\\accesoADatos.json");

        // Mostrar contenido del archivo por pantalla
        showFile("e:\\accesoADatos.json");

        // Recuperar exame desde el archivo
        Exame exameFromJson = getExamenFromJSON("e:\\accesoADatos.json");

        // Mostrar el exame recuperado por pantalla
        System.out.println("\nExamen Recuperado:");
        System.out.println(exameFromJson);


    }


    private static void saveExamToJSON(Exame examen, String nombreArchivo) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class,
                        new JsonDeserializer<LocalDateTime>() {
                            public JsonElement serialize(LocalDateTime fecha, Type type, JsonDeserializationContext jsc) {
                                JsonArray array = new JsonArray();
                                array.add(fecha.getYear());
                                array.add(fecha.getMonthValue());
                                array.add(fecha.getDayOfMonth());
                                array.add(fecha.getHour());
                                array.add(fecha.getMinute());
                                return array;



                            }
                        }).create();
               /* .registerTypeAdapter(LocalDateTime.class,
                        new JsonDeserializer<LocalDateTime> {
                   @Override
                    public JsonElement serialize(LocalDateTime fecha, Type type, JsonDeserializationContext jsc){
                        JsonPrimitive fechaSTR = new JsonPrimitive(
                                fechaSTR.getYear(),
                                fechaSTR.getMonth(),
                                fechaSTR.getDay);
                        return fechaSTR;
                    }).create();*/


        String examenJSON = gson.toJson(examen);
        try (var bw = new BufferedWriter(Paths.get(nombreArchivo));) {
            gson.toJson(examen, bw);

        } catch (IOException ex) {
            System.err.println("Error ES: " + ex.getMessage());
        }

    }

    private static void showFile(String nombreArchivo) {
        try {
            String contenido = Files.readString(Path.of(nombreArchivo));
            System.out.println("\nContenido del archivo "
                    + nombreArchivo + " JSON:" + System.lineSeparator()
                    + contenido);
        } catch (IOException e) {
            System.err.println("Error ES: " + e.getMessage());
        }
    }

    private static Exame getExamenFromJSON(String nombreArchivo) {
//        var gson = new Gson();
        var gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        LocalDateTime fecha = LocalDateTime.now();
                        String strFehca = je.getAsString();

                        String[] campos = strFehca.split("");

                        System.out.println(campos[0]);
                        System.out.println(campos[1]);

                        return fecha;
                    }
                }).create();


        try {
            String examenJSON = Files.readString(Path.of(nombreArchivo));
            return gson.fromJson(examenJSON, Exame.class);
        } catch (IOException e) {
            System.err.println("Error ES: " + e.getMessage());
        }
        return null;
    }
}



