package JAVA_NIO2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class PersoaDAO {

    private static String archivoOrigen = "ProbasExercicio1.txt";
    private static String archivoDestino = "ProbasExercicioDestino.txt";


    //Metodo para copiar un archivo en otro

    public static void copiarArchivoConNIO() {

        Path pathOrigen = Paths.get(archivoOrigen);
        Path pathDestino = Paths.get(archivoDestino);

        try {
            Files.copy(pathOrigen, pathDestino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
