package org.example;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class OrdenadoresDeserializer implements JsonDeserializer<Ordenadores> {
    @Override
    public Ordenadores deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        String id = jsonElement.getAsJsonObject().get("id").getAsString();

        //small
        String path = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("small").getAsJsonObject().get("path").getAsString();
        int width = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("small").getAsJsonObject().get("width").getAsInt();
        int height = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("small").getAsJsonObject().get("height").getAsInt();

        //medium

        String pathMedium = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("medium").getAsString();
        int widthMedium = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("medium").getAsJsonObject().get("width").getAsInt();
        int heightMedium = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("medium").getAsJsonObject().get("height").getAsInt();

        //large

        String pathLarge = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("large").getAsString();
        int widthLarge = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("large").getAsJsonObject().get("width").getAsInt();
        int heightLarge = jsonElement.getAsJsonObject().get("images").getAsJsonObject().get("large").getAsJsonObject().get("height").getAsInt();

        //datos ordenador

        String name =  jsonElement.getAsJsonObject().get("name").getAsString();
        String groupName = jsonElement.getAsJsonObject().get("groupName").getAsString();
        String singleName = jsonElement.getAsJsonObject().get("singleName").getAsString();
        String locale = jsonElement.getAsJsonObject().get("locale").getAsString();
        String offerId = jsonElement.getAsJsonObject().get("offerId").getAsString();
        double originalPrice = jsonElement.getAsJsonObject().get("originalPrice").getAsDouble();

        Ordenadores ordenadores = new Ordenadores(id, path, width, height, pathMedium, widthMedium, heightMedium, pathLarge, widthLarge, heightLarge);

        return ordenadores ;
    }
}
