package local.exame.ad.ficheros.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd");

    @Override
    public Partido deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext contexto) throws JsonParseException {
        JsonObject job = jsonElement.getAsJsonObject();
        int id = job.get("id").getAsInt();
        String date =job.get(String.valueOf(LocalDate.parse(jsonElement.getAsString(),format))).getAsString();

        Partido partido = Partido.getValueOf(home);

        int idhome = job.get("id").getAsInt();
        String abbreviation = job.get("abbreviation").getAsString();
        String city = job.get("city").getAsString();
        String conference = job.get("conference").getAsString();
        String division = job.get("division").getAsString();
        String full_name = job.get("full_name").getAsString();
        String name = job.get("name").getAsString();







        return null;
    }
}
