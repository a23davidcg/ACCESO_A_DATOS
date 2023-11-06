package Exercicio_2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ChisteTypeAdapter extends TypeAdapter<Chiste> {
    @Override
    public void write(JsonWriter out, Chiste value) throws IOException {


    }

    @Override
    public Chiste read(JsonReader jsonReader) throws IOException {

        Chiste chiste = new Chiste();

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String atributo = jsonReader.nextName();
            switch (atributo) {
                case "category":
                    chiste.setCategoria(jsonReader.nextString());
                    break;
                case "tyoe":
                    break;

                case "flags":
                    jsonReader.beginObject();
                    String campo = jsonReader.nextName();
                    switch (campo) {
                        case "racist":
                            chiste.setChiste(jsonReader.nextName());
                            XXXXXXXXXXXXXXXXXXXXXXXXXXXX
                    }
                    jsonReader.endObject();
                default:
                    jsonReader.skipValue();

            }

        }

        jsonReader.endObject();
        return chiste;
    }
}
