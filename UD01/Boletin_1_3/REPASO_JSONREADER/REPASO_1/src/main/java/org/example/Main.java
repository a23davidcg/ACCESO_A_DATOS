package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String json = "{\"nombre\": \"Juan\", \"edad\": 25, \"ciudad\": \"Barcelona\"}";

        JsonReader jsonReader = new JsonReader(new StringReader(json));

        while (jsonReader.hasNext()) {
            JsonToken siguienteToken = jsonReader.peek();

            System.out.println(siguienteToken);

            if (null != siguienteToken) {
                switch (siguienteToken) {
                    case BEGIN_OBJECT -> jsonReader.beginObject();

                    case NAME -> {
                        String nombreAtributo = jsonReader.nextName();
                        System.out.println(nombreAtributo);
                    }
                    case STRING -> {
                        String nombreValor = jsonReader.nextString();
                        System.out.println(nombreValor);
                    }
                    case NUMBER -> {
                        int edadValor = jsonReader.nextInt();
                        System.out.println(edadValor);
                    }
                    default -> {
                        jsonReader.skipValue();

                    }
                }
            }
        }
    }
}