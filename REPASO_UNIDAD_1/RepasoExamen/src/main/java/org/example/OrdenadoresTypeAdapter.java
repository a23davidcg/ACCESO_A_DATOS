package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class OrdenadoresTypeAdapter extends TypeAdapter<Ordenadores> {

    @Override
    public void write(JsonWriter writer, Ordenadores ordenadores) throws IOException {
        writer.beginObject();

        writer.name("id");
        writer.value(ordenadores.getId());

        writer.name("images");
        writer.beginObject();

        writer.name("small");
        writer.beginObject();
        //---------------------------------------------------------------

        writer.name("path");
        writer.value(ordenadores.getPath());

        writer.name("width");
        writer.value(ordenadores.getWidth());

        writer.name("height");
        writer.value(ordenadores.getHeight());

        writer.endObject();

        //....

        writer.endObject();


    }

    @Override
    public Ordenadores read(JsonReader reader) throws IOException {
        Ordenadores ordenador = new Ordenadores();


        reader.beginObject();

        while (reader.hasNext()) {
            String clave = reader.nextName();

            switch (clave) {
                case "id":
                    String id = reader.nextString();
                    ordenador.setId(id);
                    System.out.println(id);
                    break;
                case "images":
                    reader.beginObject();
                    while (reader.hasNext()) {
                        String claveImages = reader.nextName();
                        switch (claveImages) {
                            case "small":
                                reader.beginObject();
                                while (reader.hasNext()) {
                                    String claveSmall = reader.nextName();
                                    switch (claveSmall) {
                                        case "path":
                                            String path = reader.nextString();
                                            ordenador.setPath(path);
                                            System.out.println(path);
                                            break;
                                        case "width":
                                            int width = reader.nextInt();
                                            ordenador.setWidth(width);
                                            System.out.println(width);
                                            break;
                                        case "heigth":
                                            int height = ordenador.getHeight();
                                            ordenador.setHeight(height);
                                            System.out.println(height);
                                            break;
                                    }
                                }
                                reader.endObject();
                                break;
                        }

                    }
                    reader.endObject();
                    break;
            }
        }
        return ordenador;


    }
}
