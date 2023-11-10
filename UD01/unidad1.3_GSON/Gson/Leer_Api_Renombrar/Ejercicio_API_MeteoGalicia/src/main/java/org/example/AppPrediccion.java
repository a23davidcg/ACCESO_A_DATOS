package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppPrediccion {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=15078&request_locale=gl");

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder sb = new StringBuilder();
        String linha;

        while ((linha = br.readLine()) != null) {
            sb.append(linha).append(System.lineSeparator());
        }

        String json = sb.toString();

        


        System.out.println("json = " + json);


//        String json = Files.readString(Paths.get("D:\\MaquinasVirtuais\\AD\\ACCESO_A_DATOS\\unidad1.3_GSON\\Gson\\Leer_Api_Renombrar\\Ejercicio_API_MeteoGalicia\\jsonCPrazo.json"));
//
//        Gson gson = new Gson();


    }
}
