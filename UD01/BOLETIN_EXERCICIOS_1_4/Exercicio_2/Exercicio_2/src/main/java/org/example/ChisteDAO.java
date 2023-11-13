package org.example;

import java.awt.image.AbstractMultiResolutionImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

public class ChisteDAO {

    public Chiste getChiste() {

        try{
            //Cenxion con la url
            URL url = new URL ("https://v2.jokeapi.dev/joke/Programming?lang=es" + lang );

            //Lectura de la url
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
                String lineasChiste;

                while ((lineasChiste = reader.readLine()) != null) { //Read (), solo devolve enteiros, para poder leer Strings necesitamos usar readLine().
                    contenido+=lineasChiste;
                    System.out.println(lineasChiste);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Chiste getChisteByLang(String lang){
        getChiste(lang);

    }

    public Chiste getChisteByCategory(String category){
        return getChisteByCategory(getChiste() + category);
    }
}