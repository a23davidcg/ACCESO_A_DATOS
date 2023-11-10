package Ejercicio_ClasificacionDAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

public class LeerJson {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting().create();


        Gson gson = gsonBuilder.create();


        try {
            BufferedReader reader = new BufferedReader((Reader) Path.of("C:\\Users\\David\\Desktop\\DAM 2\\AD\\ACCESO_A_DATOS\\unidad1.3_GSON\\Gson\\EjerciciosGson\\Equipo.JSON5"));
            Clasificacion clasificacion = gson.fromJson(reader, Clasificacion.class);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        } catch (JsonIOException e) {
            throw new RuntimeException(e);
        }


    }
}