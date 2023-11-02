package Ejercicio_2_Producto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainProducto {
    public static void main(String[] args) {

        List<Producto> products = new ArrayList<>();

        products.add(new Producto(1234567, "Pelotas de tenis", 15.24));
        products.add(new Producto(654321, "Pelotas de golf", 23.45));
        products.add(new Producto(3456789, "Pelotas de futbol", 34.56));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(products);

        System.out.println(json);


        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("Productos.json"))) {
            bw.flush();
            bw.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
