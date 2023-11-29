package local.exame.ad.ficheros.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

/**
 * Formato del archivo JSON para Equipo:
 * {
 * "id": 2,
 * "abbreviation": "BOS",
 * "city": "Boston",
 * "conference": "East",
 * "division": "Atlantic",
 * "full_name": "Boston Celtics",
 * "name": "Celtics"
 * }
 * Adaptador para convertir de JSON a Equipo y viceversa.
 * Se utiliza para que el campo conferencia y division se conviertan a objetos Conferencia y Division.
 */
public class EquipoTypeAdapter extends TypeAdapter<Equipo> {
    /**
     * Método para convertir de Equipo a JSON.
     * No se usa, pero hay que implantarlo.
     * La Conferencia y la Division se convierten a String por medio de los métodos getNombre().
     *
     * @param writer flujo de salida.
     * @param equipo objeto de tipo Equipo.
     * @throws IOException excepción de entrada/salida.
     * @see Conferencia#getNombre()
     * @see Division#getNombre()
     * @see com.google.gson.stream.JsonWriter#name(String)
     */
    @Override
    public void write(JsonWriter writer, Equipo equipo) throws IOException {

    }

    /**
     * Método para convertir de JSON a Equipo.
     * La Conferencia y la Division se convierten a objetos Conferencia y Division por medio de los métodos
     * getConferencia(String) y getDivision(String), respectivamente, que recogen la cadena del archivo JSON y
     * devuelven el objeto correspondiente.
     *
     * @param reader flujo de entrada.
     * @return objeto de tipo Equipo.
     * @throws IOException excepción de entrada/salida.
     * @see Conferencia#getConferencia(String)
     * @see Division#getDivision(String)
     * @see JsonReader#nextName()
     */
    @Override
    public Equipo read(JsonReader reader) throws IOException {


        Equipo equipo = new Equipo();

        String contido = Files.readString(Path.of("equipos.json"));

        reader = new JsonReader(new FileReader(contido));

        while (reader.hasNext()) {
            String clave = reader.nextName();

            switch ((clave)) {
                case "id":
                    int id = reader.nextInt();
                    equipo.setIdEquipo(id);
                    break;
                case "abbreviation":
                    String abbreviation = reader.nextString();
                    equipo.setAbreviatura(abbreviation);

                    break;
                case "city":
                    String city = reader.nextString();
                    equipo.setCiudad(city);
                case "conference":
                    String conference = reader.nextString();
                    equipo.setCiudad(conference);
                case "divission":
                    String division = reader.nextString();
                    equipo.setCiudad(division);
                case "full_name":
                    String fullName = reader.nextString();
                    equipo.setCiudad(fullName);
                case "name":
                    String name = reader.nextString();
                    equipo.setCiudad(name);

            }
        }

        return equipo;
    }
}
