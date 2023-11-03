package Codigos_Postais;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class App_Codigo_Postal {


    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Lugar.class, new LugarDeserializer())
            .create();
    URL url = new URL("https://api.zippopotam.us/es/");
    BufferedReader br = new BufferedReader(
            new InputStreamReader(url.openStream()));

    Lugar lugar = gson.fromJson(br, Lugar.class);



}
