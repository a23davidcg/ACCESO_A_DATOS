/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.codigopostal.model;

/**
 * Clase adaptador para la deserialización de un objeto CodigoPostal.
 * TypeAdapter es una clase abstracta que extiende de TypeAdapter<CodigoPostal> e implanta los métodos write y read.
 * Dichos métodos se encargan de serializar y deserializar un objeto CodigoPostal, recogiendo los datos de un objeto
 * JsonReader y escribiendo los datos en un objeto JsonWriter.
 * @author pepe
 */
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class CodigoPostalTypeAdapter extends TypeAdapter<CodigoPostal> {

    /**
     * Método que se encarga de serializar un objeto CodigoPostal. Recoge los datos de un objeto JsonReader y los
     * escribe en un objeto JsonWriter.
     * El objeto JsonWriter tiene métodos para escribir los datos en un objeto JSON:
     * beginObject() -> Inicia un objeto JSON
     * endObject() -> Finaliza un objeto JSON
     * beginArray() -> Inicia un array JSON
     * endArray() -> Finaliza un array JSON
     * name(String name) -> Escribe un nombre de campo en el objeto JSON
     * value(String value) -> Escribe un valor de campo en el objeto JSON
     * @param out Objeto JsonWriter
     * @param codigoPostal Objeto CodigoPostal
     * @throws IOException Excepción de entrada/salida
     */
    @Override
    public void write(JsonWriter out, CodigoPostal codigoPostal) throws IOException {
        out.beginObject();
        out.name("post code").value(codigoPostal.getCodigoPostal());
        out.name("country").value(codigoPostal.getPais());
        out.name("country abbreviation").value(codigoPostal.getAbreviaturaPais());
        // Escribimos lista de lugares en el objeto JSON:
        out.name("places");
        out.beginArray();
        for (Lugar l : codigoPostal.getLugares()) {
            out.beginObject();
            out.name("place name").value(l.getNome());
            out.name("longitude").value(l.getLongitud());
            out.name("state").value(l.getEstado());
            out.name("state abbreviation").value(l.getAbreviaturaEstado());
            out.name("latitude").value(l.getLatitud());
            out.endObject();
        }
        out.endArray();
        out.endObject();
    }

    /**
     * Método que se encarga de deserializar un objeto CodigoPostal. Recoge los datos de un objeto JsonReader y los
     * escribe en un objeto CodigoPostal.
     * El objeto JsonReader tiene métodos para leer los datos de un objeto JSON:
     * beginObject() -> Inicia un objeto JSON
     * peek() -> Devuelve el siguiente token del objeto JSON, sin avanzar
     * endObject() -> Finaliza un objeto JSON
     * beginArray() -> Inicia un array JSON
     * endArray() -> Finaliza un array JSON
     * nextName() -> Lee el nombre de un campo en el objeto JSON
     * nextString() -> Lee el valor de un campo en el objeto JSON
     * nextDouble() -> Lee el valor de un campo en el objeto JSON como double
     * nextBoolean() -> Lee el valor de un campo en el objeto JSON como boolean
     * nextNull() -> Lee el valor de un campo en el objeto JSON como null
     * skipValue() -> Ignora el valor de un campo en el objeto JSON
     * @param in Objeto JsonReader  con los datos del objeto JSON
     * @return  Objeto CodigoPostal
     * @throws IOException
     */
    @Override
    public CodigoPostal read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        CodigoPostal cp = new CodigoPostal();
        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();
            switch (name) {
                case "post code" ->
                    cp.setCodigoPostal(in.nextString());
                case "country" ->
                    cp.setPais(in.nextString());
                case "country abbreviation" ->
                    cp.setAbreviaturaPais(in.nextString());
                case "places" -> {
                    if (in.peek() == JsonToken.NULL) { // Si el token es null, salimos del bucle
                        in.nextNull();
                        return null;
                    }
                    in.beginArray();
                    while (in.hasNext()) {
                        in.beginObject();
                        Lugar lugar = new Lugar();
                        while (in.hasNext()) {
                            switch (in.nextName()) {
                                case "place name" ->
                                    lugar.setNome(in.nextString());
                                case "state" ->
                                    lugar.setEstado(in.nextString());
                                case "longitude" ->
                                    lugar.setLongitud(in.nextDouble());
                                case "state abbreviation" ->
                                    lugar.setAbreviaturaEstado(in.nextString());
                                case "latitude" -> {
                                    lugar.setLatitud(in.nextDouble());
                                }
                                default ->
                                    in.skipValue();
                            }
                        }
                        cp.addLugar(lugar);
                        in.endObject();
                    }
                    in.endArray();
                }
                default ->
                    in.skipValue(); // ignora campos no gestionados.
            }
        }
        in.endObject();
        return cp;
    }
}
