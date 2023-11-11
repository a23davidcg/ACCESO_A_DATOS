

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader((Reader) Path.of("Original.json"));

        }catch (IOException e) {
            throw new RuntimeException();
        }
        String contenido = Files.readString();

        


    }
}