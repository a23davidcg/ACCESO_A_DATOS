package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

//A partir del ejercicio de la tarea del SUdoku, y por medio de las dos estrategias vistas anteriormente, haz que no serialice en un archivo JSON el alfabero del Sudoku y sólo lo haga con los datos. Además, debe escribirlo de manera “legible”. Crea una clase SudokuDAO con los siguientes métodos:
//
//JSON_FILE: con el nombre de fichero sudoku.json para guardar el objeto Java en formato JSON.
//Además, debe tener un atributo privado, gson, de tipo Gson para la trabajar con JSON.
//
//El constructor por defecto debe crear ese objeto de tipo Gson, pero de modo que tenga una escritura legible.
//
//La clase debe tener 6 métodos:
//
//saveToObject(Sudoku c, String ruta): que guarda el sudoku en el fichero recogido como argumento. Emplea Java NIO.2 para crear el flujo de tipo Buffered. ¿Cuál es la diferencia entre Files.newOutputStream() y new FileOutputStream()?
//saveToJSON(Sudoku c, String file): que guarda la clasificación en el fichero recogido como argumento. Emplea el objeto de tipo Gson y Java NIO.2 para guardar la cadena, a ser posible en una línea. La escritura debe tener un formato legible (no en una línea de texto).
//saveToJSON(Sudoku c): que guarda la clasificación en el fichero JSON_FILE. Emplea un objeto de tipo Gson y Java NIO.2 para guardar la cadena, a ser posible en una línea. Puedes llamar al método anterior.
//getFromJSON(String file): que obtiene la clasificación a partir del fichero recogido como argumento. Emplea Java NIO.2
//getFromJSON(): que obtiene la clasificación a partir del fichero JSON_FILE. Invoca al método anterior.

public class SudokuDAO {
    //public static final String OBJECT_FILE = "sudoku.dat"; //Non nos fai falta, foi creado por min sen ter en conta o enunciado
    public static final String JSON_FFILE = "sudoku.json";

    private Gson gson;

    //Creamos o constructor por defecto, que sempre se me olvida

    public SudokuDAO() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.setPrettyPrinting().create();

    }

    //Creamos o metodo para gardar o sudoku como un obxeto usaNDO java.NIO2

    public void saveToObject(Sudoku c, String ruta) {

        String json = "";
        Files.write(Paths.get(ruta), json.getBytes() );

      /*  try (
                FileOutputStream fos = new FileOutputStream(String.valueOf(Paths.get(ruta)));
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(c);
            oos.flush(); //Para que os bytes que se garadaron no ficheiro se saquen para fora do fluxo


        } catch (IOException e) {
            System.out.println("Error ao escribir no ficheiro");
        }*/
    }
//Creamos o metodo que nos permite gardar o sudoku nun ficheiro json mediante un path que lle metamos nos
    public void saveToJson(Sudoku c, String file) {
        try {
            Files.writeString(Paths.get(file), gson.toJson(c));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //Creamos o metodo que nos permite meter o sudoku nun json, pero tendo un path por defecto no cal se gardará

    public void saveToJson(Sudoku c) {
        saveToJson(c, JSON_FFILE);

    }

    //Creamos o metodo no cal se obten o sudoku como un json
    public Sudoku getFromJSON(String file) { //Ollo non e void, hai que cha,ar a clase de sudoku que e da que estamos obtendo o json

        try {
            String json = Files.readString(Paths.get(file));
            return gson.fromJson(json, Sudoku.class);

        } catch (IOException e) {
            return null;
        }

    }



    public Sudoku getFromJSON() {
        return getFromJSON(JSON_FFILE);


    }
}



