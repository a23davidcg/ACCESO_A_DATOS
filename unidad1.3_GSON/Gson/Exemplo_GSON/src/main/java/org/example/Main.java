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

        GsonBuilder gson = new GsonBuilder(); //Segunda formad e crear fgson, pero desta fporam podemoslle pasar parametros
        gson.setPrettyPrinting().create();
        gson.serializeNulls();//Serializar nulos

        Chuvia hoxe = new Chuvia(3.5, "Chuvascos");
        String jsonChuvia = gson.toJson(hoxe);

        //BufferedWriter bw = new BufferedWriter("Chuvia.json"); //MAneira tradicional de facer un fluxo

        try (BufferedWriter bw1 = Files.newBufferedWriter(Path.of("D:\\MaquinasVirtuais\\AD\\unidad1.3_GSON\\Gson\\Exemplo_GSON\\src\\main\\java\\org\\example\\Chuvia.json"));) {
            gson.toJson(hoxe, bw1);
        } catch (IOException e) {
            System.out.println("....");
        }


//        try {
//        BufferedReader br = Files.newBufferedReader(Path.of("D:\\MaquinasVirtuais\\AD\\unidad1.3_GSON\\Gson\\Exemplo_GSON\\src\\main\\java\\org\\example\\Chuvia.json"));
//        Chuvia chuvia  = gson.fromJson(br, Chuvia.class);
//        System.out.println(Chuvia.class);
//        }catch (IOException e){
//            throw new RuntimeException();
//        }




        System.out.println(jsonChuvia);


        //Quero escribir nun fluxo, para eso debemos de pasarlle un fluxo


    }
}