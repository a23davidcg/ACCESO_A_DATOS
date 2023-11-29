package JsonConGson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;

public class JsonReaderEjemplo {
    public static void main(String[] args) throws IOException {

        Persona persona = new Persona("David", 23, "Ciclismo");

        Gson gson = new Gson();
        String json = gson.toJson(persona);

        JsonReader reader = new JsonReader(new StringReader(json));

        reader.beginObject();

        while (reader.hasNext()) {
            String clave = reader.nextName();

            switch (clave) {
                case "nombre":
                    String nombre = reader.nextString();
                    System.out.println(nombre);
                    break;
                case "edad":
                    int edad = reader.nextInt();
                    System.out.println(edad);
                    break;
                case "aficiones":
                    String aficiones = reader.nextString();
                    System.out.println(aficiones);
                    break;
            }
        }
    }
}
