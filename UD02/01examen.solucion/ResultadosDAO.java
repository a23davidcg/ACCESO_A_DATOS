package com.pepinho.ad.ud01.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase que implementa la interfaz IResultadosDAO.
 * Dispone de una única propiedad de tipo Gson para serializar y recuperar objetos JSON. Dicha propiedad se
 * inicializa en el constructor con los adaptadores de tipos correspondientes, así como con el formato de salida
 * (pretty printing).
 * @see Resultados
 * @see IResultadosDAO
 */
public class ResultadosDAO implements IResultadosDAO {

    private final Gson gson;

    public ResultadosDAO() {
        gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(Partido.class, new PartidoDeserializer())
                .registerTypeAdapter(Equipo.class, new EquipoTypeAdapter())
                .create();
    }

    @Override
    public Resultados getResultadosFromJSON(String ruta) {
        Resultados resultados = null;
        try(var br = Files.newBufferedReader(Paths.get(ruta))) {
            resultados = gson.fromJson(br, Resultados.class);
            resultados.sort();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return resultados;
    }

    @Override
    public boolean saveResultadosToTxt(Resultados resultados, String ruta) {
        try(var bw = Files.newBufferedWriter(Paths.get(ruta))) {
            bw.write(resultados.toString());
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar los resultados: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean saveResultadosToObject(Resultados resultados, String ruta) {
        try(var oos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(Paths.get(ruta))))) {
            oos.writeObject(resultados);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar los resultados: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Resultados getResultadosFromObject(String ruta) {
        Resultados resultados = null;
        try(var ois = Files.newInputStream(Paths.get(ruta))) {
            resultados = (Resultados) new ObjectInputStream(ois).readObject();
            resultados.sort();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo binario: " + e.getMessage());
        }

        return resultados;
    }
}
