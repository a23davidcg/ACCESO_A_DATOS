package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PersonaDeserializer implements JsonSerializer<Persona>, JsonDeserializer<Persona> {

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nombre", persona.getNombre());
        jsonObject.addProperty("edad", persona.getEdad());
        return jsonObject;
    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nome = jsonObject.get("nome").getAsString();
        int edad = jsonObject.get("idade").getAsInt();
        return new Persona(nome, edad);

    }
}
