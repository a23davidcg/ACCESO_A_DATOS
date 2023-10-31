package Ejercicio_6_Clasificacion_DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Clasificacion;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClasificacionDAO {
    private static String OBJECT_FILE = "Clasififcacion.dat";
    private static String JSON_FILE = "Clasificacion.json";
    private Gson gson;

    public ClasificacionDAO() {
        Gson gb = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gb.toJson(JSON_FILE);
    }
//FIXME: revisar a partir de aqui
    public void saveToObject(Clasificacion c) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(String.valueOf(Path.of(OBJECT_FILE))));) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void saveToJson(Clasificacion c, String file) {

    }

    public void saveToJson(Clasificacion c) {

    }

    public void getFromObject() {

    }

    public void getFromJSON(String file) {

    }

    public void getFromJson() {

    }

}
