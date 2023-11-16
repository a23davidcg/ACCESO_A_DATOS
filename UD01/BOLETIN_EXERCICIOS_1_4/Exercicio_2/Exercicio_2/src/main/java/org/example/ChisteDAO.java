package org.example;

import com.google.gson.stream.JsonReader;

import java.awt.image.AbstractMultiResolutionImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

public class ChisteDAO {


    public Chiste getChiste() {


        try {
            //Cenxion con la url
            URL url = new URL("https://v2.jokeapi.dev/joke/Programming?");

            //Lectura de la url
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String lineasChiste;
                String contenido = "";

                while ((lineasChiste = reader.readLine()) != null) { //Read (), solo devolve enteiros, para poder leer Strings necesitamos usar readLine().
                    contenido += lineasChiste;
                    System.out.println(lineasChiste);
                }

                JsonReader reader1 = new JsonReader(new FileReader(contenido));

                Chiste chiste = new Chiste();

                while (reader1.hasNext()) {
                    String clave = reader1.nextName();

                    switch (clave) {
                        case "error":
                            boolean error = reader1.nextBoolean();
                            chiste.setError(error);
                            break;
                        case "category":
                            String category = reader1.nextString();
                            chiste.setCategory(category);
                            break;
                        case "type":
                            String type = reader1.nextString();
                            chiste.setType(type);
                            break;
                        case "setup":
                            String setup = reader1.nextString();
                            chiste.setSetup(setup);
                            break;
                        case "delivery":
                            String delivery = reader1.nextString();
                            chiste.setDelivery(delivery);
                            break;
                        case "flags":
                            reader1.beginObject();
                            while (reader1.hasNext()) {
                                String claveDasFlags = reader1.nextName();
                                boolean valor = reader1.nextBoolean();

                                if (valor == true) {
                                    BlackFlags flag = BlackFlags.valueOf(claveDasFlags);
                                    chiste.setFlag(flag);
                                }
                            }
                            reader1.endObject();
                        case "safe":
                            boolean safe = reader1.nextBoolean();
                            break;
                        case "id":
                            int id = reader1.nextInt();
                            chiste.setId(id);
                            break;

                        case "lang":
                            String lang = reader1.nextString();
                            chiste.setLan(lang);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   /* public Chiste getChisteByLang(String lang) {
        getChiste(lang);

    }*/

    public Chiste getChisteByCategory(String category) {
        return getChisteByCategory(getChiste() + category);
    }
}