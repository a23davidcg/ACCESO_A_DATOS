package ImplementacionExamenParcial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResultadosDAO implements IResultadosDAO {

    private final Gson gson;

    public ResultadosDAO() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Partido.class, new PartidoDeserializer())
                .registerTypeAdapter(Equipo.class, new EquipoTypeAdapter())
                .create();
    }


    @Override
    public Resultados getResultadosFromJSON(String ruta) {

        try (var br = Files.newBufferedReader(Paths.get(ruta))) {

            Resultados resultados = gson.fromJson(br, Resultados.class);
            resultados.sort();

            return resultados;

        } catch (IOException e) {
            System.err.println("Error al leer el archivo json " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean saveResultadosToTxt(Resultados resultados, String ruta) {
        try (var bw = Files.newBufferedWriter(Paths.get(ruta))) {
            bw.write(resultados.toString());
            return true;

        } catch (IOException e) {
            System.err.println("Error al guardar los resultados " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean saveResultadosToObject(Resultados resultados, String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(resultados);
            return true;

        } catch (IOException e) {
            System.err.println("Error al guardar los resultados " + e.getMessage());
        }
        return false;
    }

    @Override
    public Resultados getResultadosFromObject(String ruta) {
        Resultados resultados = null;
        try (var ois = Files.newInputStream(Paths.get(ruta))) {
            resultados = (Resultados) new ObjectInputStream(ois).readObject();
            resultados.sort();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo binario " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultados;
    }
}
