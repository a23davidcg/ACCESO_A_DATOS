package org.example;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/* Crea un proyecto Maven con una sencilla clase Examen que contenga los siguientes atributos:

materia: de tipo String.
fecha: de tipo LocalDateTime.
participantes: de tipo List de String con los nombres de los estudiantes.
Crea los métodos get/set que consideres adecuados, así como un método toString() que devuelva la materia, la fecha seguida de la lista de participantes (emplea StringBuilder).

Crea una sencilla aplicación que cree un examen de “Acceso a Datos” para el 12 de noviembre del 2023 a las 9:45 horas, con 5 estudiantes con nombres de poetas femeninas del siglo XX.

Guarda el examen en una archivo JSON llamado accesoADatos.json mediante el api de JSON-B y muestre el contenido del archivo por pantalla, utilizando Files de Java NIO.2 y recupere el archivo para guardarlo en un nuevo objeto Java.

Ayuda:

API Documentation
Dependencias básicas si no lo consigues con la versión Jakarta: https://javaee.github.io/jsonb-spec/getting-started.html*/

public class Main {
    public static void main(String[] args) throws IOException {

        //Creamoos o archivo Json onde se vai a gardar os datos
        String path = "src/main/java/org/example/accesoADatos.json";
        //Creamos un objeto en java

        LocalDateTime.of(2023, 11, 25, 9, 4);
        List.of("Juan", "Pedro", "Maria", "Jose", "Alfonso");






        //Crear el objeto Jsonb




        //Convertir el objeto a Json
        var jsonb = JsonbBuilder.create();


        try{
            Files.writeString(Path.of(path), jsonb.toJson(jsonb));
        } catch (IOException e) {
            System.out.println("Error");
        }
        System.out.println(jsonb);


        public class getContentFile (String path){
            try {
                String content = Files.readString(Path.of(path));
                System.out.println(content + path);

            }catch (IOException e) {
                System.out.println("Error");
            }
        }

        public class getContentFile2FromJson (String path){
            
        }


    }
}
