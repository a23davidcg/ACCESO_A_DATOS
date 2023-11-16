package org.example;

import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChisteDAO {

    public Chiste getChiste () {
        Path path = Paths.get("\"JokeApi.json\"");


        try {
            String lineasChiste;
            String contenido = null;

            //Files.readAllLines(path);
            while ((lineasChiste = Files.readString(path)) != null) {
                contenido += lineasChiste;

                System.out.println(lineasChiste);
            }

            JsonReader reader = new JsonReader(new FileReader(contenido));

            Chiste chiste = new Chiste();

            while (reader.hasNext()) {
                String clave = reader.nextName();

                switch (clave){
                    case "error" :
                        boolean error = reader.nextBoolean();
                        chiste.setError(error);
                        break;
                    case "category ":
                        String category = reader.nextString();
                        chiste.setCategory(category);
                        break;

                    case "flags":
                        reader.beginObject();
                        while (reader.hasNext()){
                            String claveFlags = reader.nextName();
                            boolean valor = reader.nextBoolean();

                            if (valor == true){
                                BlackFlags flag = BlackFlags.valueOf(claveFlags);
                                chiste.setBlackFlags(flag);
                            }
                        }
                }
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

