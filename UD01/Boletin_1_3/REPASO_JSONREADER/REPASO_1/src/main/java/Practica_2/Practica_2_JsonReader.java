package Practica_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Practica_2_JsonReader {
    public static void main(String[] args) throws IOException {

        Persona persona = new Persona();

        Path path = Paths.get("ArrayJson.json");

        Gson gson1 = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String toJson = gson1.toJson(persona);
        System.out.println("Asi deberia de quedar el json con formato " + toJson);

        Files.write(path, toJson.getBytes());


        try {
            String jsonContent = new String(Files.readAllBytes(path));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Persona obj = gson.fromJson(jsonContent, Persona.class);
            String datosString = obj.toString();
            System.out.println(datosString);

        } catch (IOException e) {
            System.out.println("ERROR");
        }


        try (JsonReader reader = new JsonReader(new StringReader(Files.readString(path)))) {
            reader.beginObject();

            while (reader.hasNext()) {
                JsonToken jsonToken = reader.peek();
                if (null != jsonToken) {
                    switch (jsonToken) {
                        case BEGIN_OBJECT -> reader.beginObject();

                        case NAME -> {
                            String nombreAtributo = reader.nextName();
                            System.out.println(nombreAtributo);
                        }
                        case STRING -> {
                            String valorAtributo = reader.nextString();
                            System.out.println(valorAtributo);
                        }
                        case BEGIN_ARRAY -> {
                            reader.beginArray();

                            while (reader.hasNext()) {
                                String arrayValue = reader.nextString();
                                System.out.println("Elemento del array: " + arrayValue);
                            }
                            reader.endArray();

                        }
                        default -> {

                        }

                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
