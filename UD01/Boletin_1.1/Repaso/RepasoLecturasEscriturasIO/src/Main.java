import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Iria", 23, "Alonso");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("persona.txt"))) {

            bw.write(String.valueOf(persona));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("persona.txt"))){

            String lineas;

            while ((lineas = br.readLine()) != null){
                System.out.println(lineas);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            List<String> palabras = Files.readAllLines(Path.of("persona.txt"));

            System.out.println("Esto estase leendo con java nio2 a modo de proba");
            System.out.println(palabras);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}