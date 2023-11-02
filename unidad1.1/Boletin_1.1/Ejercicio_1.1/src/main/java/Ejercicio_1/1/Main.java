

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader((Reader) Path.of("Original.json"));

        }catch (IOException e) {
            throw new RuntimeException();
        }
    }
}