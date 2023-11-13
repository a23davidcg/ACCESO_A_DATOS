package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Persona persona = new Persona("David", 23);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, new PersonaDeserializer())
                .setPrettyPrinting()
                .create();
        //Convertir el json a un string
        String resultado = gson.toJson(persona);

        System.out.println(resultado);
        System.out.println("json creado satisfactoriamente. ");


        // PARA LLEVAR A CABO EL JSONREADER

        JsonReader jsonReader = new JsonReader(new StringReader(resultado));

        while (jsonReader.hasNext()) {
            JsonToken siguienteToken = jsonReader.peek();
            System.out.println(siguienteToken);

            if (null != siguienteToken) {
                switch (siguienteToken) {
                    case BEGIN_OBJECT -> //Si es un objeto se come las llaves
                            jsonReader.beginObject();

                    case NAME -> { //Si es un nombre se muestra el nombre del atributo que corresponda
                        String nombreAtributo = jsonReader.nextName();
                        System.out.println(nombreAtributo);

                    }
                    case STRING -> { //Si es una cadena de caracteres se muestra
                        String valorString = jsonReader.nextString();
                        System.out.println(valorString);

                    }
                    case NUMBER -> { //Si es un numero se muestra el valor del mismo
                        int edadAtributo = jsonReader.nextInt();
                        System.out.println(edadAtributo);

                    }
                    default -> {
                        System.out.println("Ninguno de los valores que se buscan existe. ");

                    }
                }
            }
        }
    }
}

