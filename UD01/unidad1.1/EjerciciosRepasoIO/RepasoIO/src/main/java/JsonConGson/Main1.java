package JsonConGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main1 {
    public static void main(String[] args) {

        Persona persona = new Persona("David", 23, "Ciclismo");

        //Convertir objeto a json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(persona);

        try(Writer writer = new FileWriter("persona.json")){

            writer.write(json);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        //Debemos de coger el contenido del fichero
//
//
//        //El contenido del json lo debemos de convertir a objeto
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("persona.json"));
//
//            String lineas;
//            while ((lineas = br.readLine()) != null) {
//
//                System.out.println(lineas);
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        try(BufferedReader br = new BufferedReader(
                new FileReader("persona.json"))){

            String lineas;

            while ((lineas=br.readLine())!=null){

                System.out.println(lineas);
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
