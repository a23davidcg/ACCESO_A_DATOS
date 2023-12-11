package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DAO {

    private final Gson gson;

    public DAO() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Ordenadores.class, new OrdenadoresDeserializer())
                .registerTypeAdapter(Ordenadores.class, new OrdenadiresSerielizer())
                .create();
    }

    Ordenadores getOrdenadoresFromJson(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader("ordenadores.json"))) {

            Ordenadores ordenadores = gson.fromJson(br, Ordenadores.class);

            return ordenadores;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    boolean saveOrdenadoresToTxt(Ordenadores ordenadores, String ruta) {

        try (var writer = Files.newBufferedWriter(Paths.get(ruta))) {


            String ordenadoresString = gson.toJson(ordenadores);

            writer.write(ordenadoresString);
            return true;


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }

    boolean saveOrdenadoresToObject(Ordenadores ordenadores, String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(ordenadores);
            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    Ordenadores getOrdenadoresFromObject(String ruta) {

        Ordenadores ordenadores;
        try(var ois = Files.newInputStream(Paths.get(ruta))){
            ordenadores = (Ordenadores) new ObjectInputStream(ois).readObject();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ordenadores;
    }

}
