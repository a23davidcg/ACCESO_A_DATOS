package org.example;

import com.google.gson.*;

import java.io.Serializable;
import java.lang.reflect.Type;

public class OrdenadiresSerielizer implements JsonSerializer<Ordenadores> {
    @Override
    public JsonElement serialize(Ordenadores ordenadores, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();

        json.add("id", new JsonPrimitive(ordenadores.getId()));

        JsonObject jsonImages = new JsonObject();
        JsonObject jsonSmall = new JsonObject();
        jsonSmall.add("path", new JsonPrimitive(ordenadores.getPath()));
        jsonSmall.add("width", new JsonPrimitive(ordenadores.getWidth()));
        jsonSmall.add("heigth", new JsonPrimitive(ordenadores.getHeight()));


        jsonImages.add("small", jsonSmall );
        json.add("images", jsonImages);


        //.........................................................

        return json;

    }
}
