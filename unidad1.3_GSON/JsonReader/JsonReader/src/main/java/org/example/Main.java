package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url =new URL("https://servizos.meteogalicia.gal");

        new InputStreamReader(url.openStream());

        JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Paths.get("Clasificacion.json")));

        while (jsonReader.hasNext()) {
            JsonToken siguienteToken = jsonReader.peek();
            System.out.println(siguienteToken);

            if(null != siguienteToken){
                switch (siguienteToken){
                    case BEGIN_ARRAY ->
                        jsonReader.beginArray();
                    case BEGIN_OBJECT ->
                        jsonReader.beginObject();
                    case NAME -> {
                            String nomeAtributo = jsonReader.nextName();
                            System.out.println(nomeAtributo);}
                    case NUMBER -> {
                        long valorNumeros = jsonReader.nextLong();
                        System.out.println(valorNumeros);
                    }
                    case
                }
            }


            if (JsonToken.BEGIN_OBJECT.equals(siguienteToken)) {
                // Si es un objeto, consumimos las llaves {
                jsonReader.beginObject();

            } else if (JsonToken.NAME.equals(siguienteToken)) {
                // Si es un nombre de atributo, lo imprimimos.
                String nomeAtributo = jsonReader.nextName();
                System.out.println(nomeAtributo);

            } else if (JsonToken.STRING.equals(siguienteToken)) {
                // si es una cadena, recuperamos String y la imprimimos
                String valorString = jsonReader.nextString();
                System.out.println(valorString);

            } else if (JsonToken.NUMBER.equals(siguienteToken)) {
                // Si es un número, OJO con los tipos...
                long valorNumero = jsonReader.nextLong();
                System.out.println(valorNumero);

            }

        }


    }
}