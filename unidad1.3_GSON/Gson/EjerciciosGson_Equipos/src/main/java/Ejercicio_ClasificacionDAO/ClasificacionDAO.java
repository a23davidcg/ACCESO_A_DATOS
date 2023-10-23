package Ejercicio_ClasificacionDAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClasificacionDAO {


    public static final String OBJECT_FILE = "clasificacion.dat";
    public static final String JSON_FILE = "Clasificacion.json";


    private Gson gson;


    public ClasificacionDAO() {//Constructor por defecto
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.setPrettyPrinting().create();
    }

    // Método para guardar la clasificación en el fichero OBJECT_FILE
    public void saveToObject(Clasificacion c) {
        try (FileOutputStream fos = new FileOutputStream(OBJECT_FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(c);
            oos.flush();//Para que todos os bytes que ten na lista almacenados que os escriba

        } catch (IOException e) {
            System.out.println("Error ao escribir no ficheiro");
        }
    }

    // Método para guardar la clasificación en un fichero JSON especificado

    //TODO: Cambiar as excepcions para gestionalas dentro do metodo

    //
    public void saveToJSon(Clasificacion c, String file) { //Garda o archivo no archivo que nos lle indicamos

        try {
            Files.writeString(Paths.get(file), gson.toJson(c));
        } catch (IOException e) {
            System.out.println("Produceuse un error. ");
        }

    }

    // Método para guardar la clasificación en el fichero JSON_FILE
    public void saveToJson(Clasificacion c) { //Garda o archivo no ficheiro que xa temos dentro deo JSON_FILE

        saveToJSon(c, JSON_FILE);
    }

    // Método para obtener la clasificación desde el fichero OBJECT_FILE
    public Clasificacion getFromObject() {

        //try (FileInputStream fis = new FileInputStream(OBJECT_FILE);
        //           new BufferedInputStream (ObjectInputStream ois = new ObjectInputStream(fis));)

        try (FileInputStream fis = new FileInputStream(OBJECT_FILE);
           ObjectInputStream ois = new ObjectInputStream(fis);) { //Pregutnar a david si facelo con buffered e mais eficiente que facelo sen eles.

            Object read = ois.readObject();
            return (Clasificacion) read;

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    // Método para obtener la clasificación desde un fichero JSON especificado
    public Clasificacion getFromJSON(String file) {

        try {
            String json = Files.readString(Paths.get(file));
            return gson.fromJson(json, Clasificacion.class);
        } catch (IOException e) {
            return null;
        }
    }

    // Método para obtener la clasificación desde el fichero JSON_FILE
    public Clasificacion getFromJSON() {
        return getFromJSON(JSON_FILE);
    }


}
