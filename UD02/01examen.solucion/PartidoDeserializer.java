package com.pepinho.ad.ud01.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Clase que implementa la interfaz JsonDeserializer para deserializar el archivo JSON de partidos.
 * Formato del archivo JSON para Partido:
 * {
 * "id": 857369,
 * "date": "2022-10-20T00:00:00.000Z",
 * "home_team": {
 * "id": 14,
 * "abbreviation": "LAL",
 * "city": "Los Angeles",
 * "conference": "West",
 * "division": "Pacific",
 * "full_name": "Los Angeles Lakers",
 * "name": "Lakers"
 * },
 * "home_team_score": 97,
 * "period": 4,
 * "postseason": false,
 * "season": 2022,
 * "status": "Final",
 * "time": "Final",
 * "visitor_team": {
 * "id": 13,
 * "abbreviation": "LAC",
 * "city": "LA",
 * "conference": "West",
 * "division": "Pacific",
 * "full_name": "LA Clippers",
 * "name": "Clippers"
 * },
 * "visitor_team_score": 103
 * }
 * <p>
 * Esta clase se utiliza para deserializar el archivo JSON de partidos:
 * - Los campos equipoLocal (home_team) y equipoVisitante (visitor_team) se conviertan a objetos Equipo,
 * invocando al método deserialize del contexto.
 * - La fecha recogida como cadena se convierte en LocalDate por medio del método estático parse de la clase LocalDate.
 * Este método recoge la cadena en formato "yyyy-mm-dd" y devuelve un objeto LocalDate.
 * - La correspondencia del resto de campos es directa (getAsInt(), getAsString(), getAsBoolean()).
 */

public class PartidoDeserializer implements JsonDeserializer<Partido> {

    @Override
    public Partido deserialize(JsonElement jsonElement, Type type,
                               JsonDeserializationContext contexto) throws JsonParseException {

        if (!jsonElement.isJsonObject())
            return null;
        Partido partido = new Partido();
        jsonElement.getAsJsonObject().entrySet().forEach(entry -> {
            switch (entry.getKey()) {
                case "id" -> partido.setIdPartido(entry.getValue().getAsInt());
                case "date" -> partido.setFecha(LocalDate.parse(entry.getValue().getAsString().substring(0, 10)));
                case "home_team" -> partido.setEquipoLocal(contexto.deserialize(entry.getValue(), Equipo.class));
                case "home_team_score" -> partido.setPuntosLocal(entry.getValue().getAsInt());
                case "period" -> partido.setPeriodo(entry.getValue().getAsInt());
                case "postseason" -> partido.setPostemporada(entry.getValue().getAsBoolean());
                case "season" -> partido.setTemporada(entry.getValue().getAsInt());
                case "status" -> partido.setEstado(entry.getValue().getAsString());
                case "time" -> {
                    if (!entry.getValue().isJsonNull())
                        partido.setTiempo(entry.getValue().getAsString());
                }
                case "visitor_team" -> partido.setEquipoVisitante(contexto.deserialize(entry.getValue(), Equipo.class));
                case "visitor_team_score" -> partido.setPuntosVisitante(entry.getValue().getAsInt());
                default -> {
                    System.out.println("Campo no reconocido: " + entry.getKey());
                    System.out.println("Valor: " + entry.getValue());
                }
            }
        });

        return partido;
    }
}
