package ImplementacionExamenParcial;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


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
     * <p>
     * //     * @param writer flujo de salida.
     * //     * @param equipo objeto de tipo Equipo.
     * //     * @throws IOException excepción de entrada/salida.
     * //     * @see Conferencia#getNombre()
     * //     * @see Division#getNombre()
     * //     * @see com.google.gson.stream.JsonWriter#name(String)
     * //
     */
    @Override
    public void write(JsonWriter writer, Equipo equipo) throws IOException {
        writer.beginObject();

        writer.name("id");
        writer.value(equipo.getIdEquipo());

        writer.name("abbreviation");
        writer.value(equipo.getAbreviatura());

        writer.name("city");
        writer.value(equipo.getCiudad());

        writer.name("conference");
        writer.value(equipo.getConferenciaAsString());

        writer.name("division");
        writer.value(equipo.getDivisionAsString());

        writer.name("full_name");
        writer.value(equipo.getNombreCompleto());

        writer.name("name");
        writer.value(equipo.getNombre());

        writer.endObject();


    }

    /**
     * Método para convertir de JSON a Equipo.
     * La Conferencia y la Division se convierten a objetos Conferencia y Division por medio de los métodos
     * getConferencia(String) y getDivision(String), respectivamente, que recogen la cadena del archivo JSON y
     * devuelven el objeto correspondiente.
     * <p>
     * //     * @param reader flujo de entrada.
     * //     * @return objeto de tipo Equipo.
     * //     * @throws IOException excepción de entrada/salida.
     * //     * @see Conferencia#getConferencia(String)
     * //     * @see Division#getDivision(String)
     * //     * @see JsonReader#nextName()
     * //
     */
    @Override
    public Equipo read(JsonReader reader) throws IOException {

        Equipo equipo = new Equipo();

        String clave = reader.nextName();

        reader.beginObject();

        while (reader.hasNext()) {
            switch (clave) {
                case "id":
                    int id = reader.nextInt();
                    equipo.setIdEquipo(id);
                    System.out.println(id);
                    break;
                case "abreviation":
                    String abreviation = reader.nextString();
                    equipo.setAbreviatura(abreviation);
                    System.out.println(abreviation);
                    break;
                case "city":
                    String city = reader.nextString();
                    equipo.setCiudad(city);
                    System.out.println(city);
                    break;
                case "conference":
                    String conference = reader.nextString();
                    equipo.setConferencia(conference);
                    System.out.println(conference);
                    break;
                case "division":
                    String division = reader.nextString();
                    equipo.setDivision(division);
                    System.out.println(division);
                    break;
                case "full_name":
                    String fullName = reader.nextString();
                    equipo.setNombreCompleto(fullName);
                    System.out.println(fullName);
                    break;
                case "name":
                    String name = reader.nextString();
                    equipo.setNombre(name);
                    System.out.println(name);
                default:
            }
        }
        return equipo;
    }
}
