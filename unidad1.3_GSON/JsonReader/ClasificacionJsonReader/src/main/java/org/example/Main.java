package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(new FileReader("Clasificacion.json"));

        try {
            while (jsonReader.hasNext()){ //Mentres teña elementos leo os equipos
                JsonToken siguienteToken = jsonReader.peek();
                System.out.println();

                if (JsonToken.BEGIN_OBJECT.equals(siguienteToken)){
                    //Si es un objeto consumimos las laves

                    jsonReader.beginObject();
                }else if (JsonToken.NAME.equals(siguienteToken)){
                    String nome = jsonReader.nextName();
                    System.out.println(nome);
                } else if (JsonToken.STRING.equals(siguienteToken)) {
                    String valorString = jsonReader.nextString();
                    System.out.println(valorString);

                } else if (JsonToken.NUMBER.equals(siguienteToken)) {
                    long valorNumero = jsonReader.nextLong();
                    System.out.println(valorNumero);
                }
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}