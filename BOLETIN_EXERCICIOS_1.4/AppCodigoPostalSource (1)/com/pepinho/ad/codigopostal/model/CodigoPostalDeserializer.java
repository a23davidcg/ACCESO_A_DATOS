/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.codigopostal.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 *  Creado por Pepinho con fines educativos. Fai o queiras.
 *  Esta clase deserializa un objeto CodigoPostal por medio de la librería Gson, implementando
 *  la interfaz JsonDeserializer<CodigoPostal>.
 *  Para ello, sobreescribe el método deserialize, que recibe como parámetros un objeto JsonElement,
 *  un objeto Type y un objeto JsonDeserializationContext.
 *  El objeto JsonElement es el objeto que se va a deserializar, el objeto Type es el tipo de objeto
 *  que se va a deserializar y el objeto JsonDeserializationContext es el contexto de deserialización.
 *
 *  Existe otro modo de deserializar un objeto, como por ejemplo, implementando la interfaz
 *  JsonDeserializer<CodigoPostal> en la clase CodigoPostal o utilizando un TypeAdapter, que es
 *  una clase que extiende de TypeAdapter<CodigoPostal> y hereda los métodos write y read.
 *  Puede verse un ejemplo de TypeAdapter en la clase CodigoPostalTypeAdapter.
 *
 *  Se recomienda usar TypeAdapter cuando se quiere modificar el proceso de serialización, pues
 *  es más sencillo y más limpio. Además, se puede usar para serializar y deserializar objetos
 *  de cualquier tipo, no solo de un tipo concreto.
 *
 *  En cuanto a eficiencia, TypeAdapter es más eficiente que JsonDeserializer, pues no necesita
 *  crear un objeto JsonDeserializationContext y no precisa cargar el objeto en memoria.
 *
 * @author pepe
 * @see com.google.gson.JsonDeserializer
 * @see com.google.gson.JsonElement
 * @see com.google.gson.JsonObject
 * @see com.google.gson.JsonDeserializationContext
 * @see com.google.gson.JsonParseException
 * @see com.google.gson.reflect.TypeToken
 */
public class CodigoPostalDeserializer implements JsonDeserializer<CodigoPostal> {
    @Override
    public CodigoPostal deserialize(JsonElement je, Type type, 
            JsonDeserializationContext jdc) 
            throws JsonParseException {
        if (je.isJsonNull()) {
            return null;
        }
        JsonObject jObject = je.getAsJsonObject();
        // Obtenemos los datos del objeto JSON
        if(jObject.get("post code").isJsonNull()){
            return null;
        }
        String codigoPostal = (!jObject.get("post code").isJsonNull()) ? jObject.get("post code").getAsString() : "";
        String pais = (jObject.get("country")!=null && !jObject.get("country").isJsonNull()) ?
                jObject.get("country").getAsString() : "";
        String abreviaturaPais = jObject.get("country abbreviation").getAsString();
        JsonArray lugares = jObject.get("places").getAsJsonArray();

        CodigoPostal cp = new CodigoPostal(codigoPostal, pais, abreviaturaPais);
//        // Otro modo de hacerlo
//        List<Lugar> sitios = jdc.deserialize(jObject.get("places"), new TypeToken<List<Lugar>>(){}.getType());
//        cp.setLugares(sitios);
        if(lugares == null){
            return cp;
        }
        for (JsonElement lugar : lugares) {
            JsonObject obj = lugar.getAsJsonObject();
            String nome = obj.get("place name").getAsString();
//            double longitude = Double.parseDouble(obj.get("longitude").getAsString());
            double longitude = obj.get("longitude").getAsDouble();
            String estado = obj.get("state").getAsString();
            String abreviaturaEstado = obj.get("state abbreviation").getAsString();
            double latitud = obj.get("latitude").getAsDouble(); //
            // latitud 0 Double.parseDouble(obj.get("latitude").getAsString());
            cp.addLugar(new Lugar(nome, longitude, latitud, estado, abreviaturaEstado));
        }

        return cp;
    }
    
}
