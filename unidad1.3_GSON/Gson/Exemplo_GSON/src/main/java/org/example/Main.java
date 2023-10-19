package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        //Gson gson = new Gson(); //Primeira maneira de crear gson

        GsonBuilder gbuilder = new GsonBuilder(); //Segunda formad e crear fgson, pero desta fporam podemoslle pasar parametros
        gbuilder.setPrettyPrinting().create();
        gbuilder.serializeNulls();//Serializar nulos
        gbuilder.excludeFieldsWithModifiers();

        Gson gson1 = gbuilder.create();

        Chuvia hoxe = new Chuvia(3.5, "Chuvascos");
        String jsonChuvia = gson1.toJson(hoxe);

        //BufferedWriter bw = new BufferedWriter("Chuvia.json"); //MAneira tradicional de facer un fluxo

        //escribir nun archivo dende json
//        try (BufferedWriter bw1 = Files.newBufferedWriter(Path.of("D:\\MaquinasVirtuais\\AD\\unidad1.3_GSON\\Gson\\Exemplo_GSON\\src\\main\\java\\org\\example\\Chuvia.json"));) {
//            gson1.toJson(hoxe, bw1);
//        } catch (IOException e) {
//            System.out.println("....");
//        }

//      Leer un archivo con formato json e mostralo por pantalla usando os fluxos de NIO
        BufferedReader br = null;
        try {
        BufferedReader br = Files.newBufferedReader(Path.of("D:\\MaquinasVirtuais\\AD\\unidad1.3_GSON\\Gson\\Exemplo_GSON\\src\\main\\java\\org\\example\\Chuvia.json"));
        Chuvia chuvia  = gson1.fromJson(br, Chuvia.class);
        System.out.println(Chuvia.class);
        }catch (IOException e){
            throw new RuntimeException();
        }
        System.out.println(jsonChuvia);
        //Quero escribir nun fluxo, para eso debemos de pasarlle un fluxo
    }
}