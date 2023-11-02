package Ejercicio_6_Clasificacion_DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Clasificacion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClasificacionDAO {
    private static String OBJECT_FILE = "clasififcacion.dat";
    private static String JSON_FILE = "Clasificacion1.json";
    private Gson gson;

    public ClasificacionDAO() { //Constructor por defecto
         gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    //FIXME: revisar a partir de aqui
    public void saveToObject(Clasificacion c) {
        try (BufferedOutputStream fos = new BufferedOutputStream(
                new FileOutputStream(OBJECT_FILE));
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(c);
            oos.flush();
        } catch (IOException e) {
            System.out.println("Error ao escribir no ficheiro");
        }
    }
    public void saveToJson(Clasificacion c, String file) {
        try {
            Files.writeString(Paths.get(file), gson.toJson(c));
        } catch (IOException e) {
            System.out.println("ERRO ao escribir o archivo");
        }
    }

    public void saveToJson(Clasificacion c) { //Garda o ficheiro que xa temos dentro do json file
        saveToJson(c, JSON_FILE);
    }


    public Clasificacion getFromObject() {

        try (FileInputStream fis = new FileInputStream(OBJECT_FILE);
             ObjectInputStream ois = new ObjectInputStream(fis);) {

            Object read = ois.readObject();
            return (Clasificacion) read;

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public Clasificacion getFromJSON(String file) {
        try {
            String json = Files.readString(Paths.get(file));
            return gson.fromJson(json, Clasificacion.class);

        } catch (IOException e) {
            return null;
        }
    }

    public Clasificacion getFromJSON(){return getFromJSON(JSON_FILE);
    }

}
