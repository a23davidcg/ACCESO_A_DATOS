/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.codigopostal.model;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Clase deserializadora de un objeto Lugar. Implementa la interfaz JsonDeserializer<Lugar>.
 * Para ello, sobreescribe el método deserialize, que recibe como parámetros un objeto JsonElement,
 *  un objeto Type y un objeto JsonDeserializationContext.
 *  El objeto JsonElement es el objeto que se va a deserializar, el objeto Type es el tipo de objeto
 *  que se va a deserializar y el objeto JsonDeserializationContext es el contexto de deserialización.
 *
 *  Existe otro modo de deserializar un objeto, como por ejemplo, implementando la clase TypeAdapter,
 *  que es una clase que extiende de TypeAdapter<Lugar> e implanta los métodos write y read.
 *
 *  Se recomienda usar TypeAdapter cuando se quiere modificar el proceso de serialización, pues
 *  es más sencillo y más limpio. Además, se puede usar para serializar y deserializar objetos
 *  de cualquier tipo, no solo de un tipo concreto.
 *
 * @author pepe
 */
public class LugarDeserializer implements JsonDeserializer<Lugar> {
    @Override
    public Lugar deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) 
            throws JsonParseException {
        if(je.isJsonNull()){
            return null;
        }
        JsonObject jObject = je.getAsJsonObject();
        String nome = jObject.get("place name").getAsString();
        int longitud = jObject.get("longitude").getAsInt();
        String estado = jObject.get("state").getAsString();
        String abreviaturaEstado = jObject.get("state abbreviation").getAsString();
        int latitud = jObject.get("latitude").getAsInt();
        return new Lugar(nome, longitud, latitud, estado, abreviaturaEstado);
    }
    
}
