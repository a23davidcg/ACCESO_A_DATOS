package Ejercicio_2_CGPT_ConvertirJsonAListaObjetos;

import com.solidfire.gson.Gson;
import com.solidfire.gson.GsonBuilder;
import com.solidfire.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Deseamos pasar de un json a una lista de objetos usasndo gson

        String jsonLibros = "[{\"titulo\":\"Libro1\",\"autor\":\"Autor1\",\"anioPublicacion\":2000}," +
                "{\"titulo\":\"Libro2\",\"autor\":\"Autor2\",\"anioPublicacion\":2010}]";


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type tipoListaLibros = new TypeToken<List<Libro>>() {
        }.getType();
        List<Libro> LibrosLista = gson.fromJson(jsonLibros, tipoListaLibros);

        for (Libro libro : LibrosLista) {
            System.out.println("Titulo" + libro.nome + "Autor: " + libro.autor + "anioPublicacion: " + libro.anioPublicacion);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("GuardarLibro.json"))) {
            String litstaLibrosJson = gson.toJson(LibrosLista);

            bw.write(litstaLibrosJson);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
