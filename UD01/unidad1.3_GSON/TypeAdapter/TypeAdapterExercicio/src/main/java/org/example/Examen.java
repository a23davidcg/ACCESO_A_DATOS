/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

/**
 *
 * @author pepe
 */
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

//import javax.json.bind.Jsonb;
//import javax.json.bind.JsonbBuilder;
//import javax.json.bind.JsonbConfig;
//import javax.json.bind.JsonbException;
public class Examen {

    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Examen() {
        // Constructor vacío necesario para JSON-B
    }

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
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

    public class LocalDateTimeAdapter extends TypeAdapter <LocalDateTime>
    

    public static void main(String[] args) {
        // Crear exame
        Examen exame = new Examen("Acceso a Datos",
                LocalDateTime.of(2023, 11, 12, 9, 45),
                List.of("Gabriela Mistral",
                        "Silvina Ocampo",
                        "Juana de Ibarbourou",
                        "Carmen Conde",
                        "Claribel Alegría"));

        // Convertir exame a JSON y guardarlo en un archivo
        saveExamToJSON(exame, "e:\\accesoADatos.json");

        // Mostrar contenido del archivo por pantalla
        getContentFile("e:\\accesoADatos.json");

        // Recuperar exame desde el archivo
        Examen exameFromJson = getExamenFromJSON("e:\\accesoADatos.json");

        // Mostrar el exame recuperado por pantalla
        System.out.println("\nExamen Recuperado:");
        System.out.println(exameFromJson);
    }

    private static void saveExamToJSON(Examen examen, String nombreArchivo) {

        JsonbConfig configuracion = new JsonbConfig();
        configuracion.withFormatting(true);
        var jsonb = JsonbBuilder.newBuilder().withConfig(configuracion).build();

//        var jsonb = JsonbBuilder.create();

        String examenJSON = jsonb.toJson(examen);
        try {
            Files.writeString(Path.of(nombreArchivo), examenJSON);
        } catch (IOException ex) {
            System.err.println("Error ES: " + ex.getMessage());
        }

    }

    private static void getContentFile(String nombreArchivo) {
        try {
            String contenido = Files.readString(Path.of(nombreArchivo));
            System.out.println("\nContenido del archivo "
                    + nombreArchivo + " JSON:" + System.lineSeparator()
                    + contenido);
        } catch (IOException e) {
            System.err.println("Error ES: " + e.getMessage());
        }
    }

    private static Examen getExamenFromJSON(String nombreArchivo) {
        var jsonb = JsonbBuilder.create();
        try {
            String examenJSONString = Files.readString(Path.of(nombreArchivo));
            return jsonb.fromJson(examenJSONString, Examen.class);
        } catch (IOException e) {
            System.err.println("Error ES: " + e.getMessage());
        } 
        return null;
    }
}
