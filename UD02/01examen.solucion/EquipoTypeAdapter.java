package com.pepinho.ad.ud01.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
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
        if (equipo == null) {
            writer.nullValue();
            return;
        }
        writer.beginObject();
        writer.name("id")
                .value(equipo.getIdEquipo())
                .name("abbreviation").value(equipo.getAbreviatura())
                .name("city").value(equipo.getCiudad());
        writer.name("conference").value(equipo.getConferenciaAsString());
        writer.name("division").value(equipo.getDivisionAsString());
        writer.name("full_name").value(equipo.getNombreCompleto());
        writer.name("name").value(equipo.getNombre());
        writer.endObject();
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

        reader.beginObject();
        while (reader.hasNext()) {
            String nombre = reader.nextName();
            if (reader.peek() == JsonToken.NULL) {
                reader.skipValue();
            } else {
                switch (nombre) {
                    case "id" -> equipo.setIdEquipo(reader.nextInt());
                    case "name" -> equipo.setNombre(reader.nextString());
                    case "division" -> equipo.setDivision(Division.getDivision(reader.nextString()));
                    case "conference" -> equipo.setConferencia(Conferencia.getConferencia(reader.nextString()));
                    case "city" -> equipo.setCiudad(reader.nextString());
                    case "abbreviation" -> equipo.setAbreviatura(reader.nextString());
                    case "full_name" -> equipo.setNombreCompleto(reader.nextString());
                    default -> reader.skipValue();
                }
            }
        }
        reader.endObject();
        return equipo;
    }


}
