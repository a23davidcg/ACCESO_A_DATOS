package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {




    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Poeta.class, new CreadorDePoetas());

        Gson gson  = gsonBuilder.create();
        String poetaJson = "{ \"nome\" : \"Anne Sexton\",  \"idade\" : 45}";

        Poeta poeta = gson.fromJson(poetaJson, Poeta.class);

// se supone que poeta tiene un campo denominado categoria.
        System.out.println(poeta.getCategoria());

    


    }


}