package ImplementacionExamenParcial;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

        //Datos partido
        int id = jsonElement.getAsJsonObject().get("id").getAsInt();
        String fechaPArtido = jsonElement.getAsJsonObject().get("date").getAsString();

        //Datos de equipo local
        int iEquipoLocal = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("id").getAsInt();
        String city = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("city").getAsString();
        String abbreviation = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("abbreviation").getAsString();
        String conference = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("conference").getAsString();
        String division = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("division").getAsString();
        String fullName = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("full_name").getAsString();
        String name = jsonElement.getAsJsonObject().get("home_team").getAsJsonObject().get("name").getAsString();

        //Datos de partido
        int homeTeamScore = jsonElement.getAsJsonObject().get("home_team_score").getAsInt();
        int period = jsonElement.getAsJsonObject().get("period").getAsInt();
        boolean postseason = jsonElement.getAsJsonObject().get("postseason").getAsBoolean();
        int season = jsonElement.getAsJsonObject().get("season").getAsInt();
        String status = jsonElement.getAsJsonObject().get("status").getAsString();
        String time = jsonElement.getAsJsonObject().get("time").getAsString();

        //Datos de equipo visitante
        int id1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("id").getAsInt();
        String abbreviation1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("abbreviation").getAsString();
        String city1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("city").getAsString();
        String conference1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("conference").getAsString();
        String division1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("division").getAsString();
        String fullname1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("full_name").getAsString();
        String name1 = jsonElement.getAsJsonObject().get("visitor_team").getAsJsonObject().get("name").getAsString();
        int puntosEquipoVisitante = jsonElement.getAsJsonObject().get("visitor_team_score").getAsInt();


        //PAra obter o tipo de conferencia do equipo local
        Conferencia confderenciaLocal = Conferencia.getConferencia(conference);
        Division divisionEquipoLocal = Division.getDivision(division);

        //Fecha
        LocalDate fecha = LocalDate.parse(fechaPArtido, DateTimeFormatter.ISO_DATE_TIME); //A fecha esta en formato ISO xa preestablecido

        String fechaComoString = fecha.format(DateTimeFormatter.ISO_DATE); //No caso de que houbera que oasar de tipo date a String, que neste caso non fai falta SOLO E UN EXEMPLO


        //Equipos
        Equipo equipoLocal = new Equipo(iEquipoLocal, abbreviation, city, confderenciaLocal, divisionEquipoLocal, fullName, name  );

        Equipo equipoVisitante = new Equipo(id1, abbreviation1, city1, conference1, division1,fullname1, name1);

        //Pasarlle os parametros ao partido

        Partido partido = new Partido(id, fecha, equipoLocal, homeTeamScore, period, postseason,season,status, time,equipoVisitante, puntosEquipoVisitante   );

        return partido; //FIXME cambiar a devoover partido

        //TODO Completar este metdoo e comprobar que todo funciona

    }
}
