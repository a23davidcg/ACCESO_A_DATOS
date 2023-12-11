package ImplementacionExamenParcial.parte1;

import ImplementacionExamenParcial.Partido;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PartidoSerializer implements JsonSerializer<Partido> {
    @Override
    public JsonElement serialize(Partido partido, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("id", new JsonPrimitive(partido.getIdPartido()));
        jsonObject.add("date", new JsonPrimitive(partido.getFecha()));

        JsonObject jsonHomeTeam = new JsonObject();
        jsonObject.add("home_team", jsonHomeTeam);

        jsonHomeTeam.add("id", partido.getEquipoLocal());
        jsonHomeTeam.add("abbreviation", partido.get);

    }
}
