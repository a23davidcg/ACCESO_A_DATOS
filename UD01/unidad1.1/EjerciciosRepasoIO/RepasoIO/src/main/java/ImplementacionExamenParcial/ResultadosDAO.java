package ImplementacionExamenParcial;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResultadosDAO implements IResultadosDAO{

    @Override
    public Resultados getResultadosFromJSON(String ruta) {

        try {
            Path path = Paths.get(ruta);

            String contenido = new String(Files.readAllBytes(path));

            Gson gson = new Gson();
            Resultados resultados = gson.fromJson(contenido, Resultados.class);

            return resultados;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveResultadosToTxt(Resultados resultados, String ruta) {

        
        return false;
    }

    @Override
    public boolean saveResultadosToObject(Resultados resultados, String ruta) {
        return false;
    }

    @Override
    public Resultados getResultadosFromObject(String ruta) {
        return null;
    }
}
