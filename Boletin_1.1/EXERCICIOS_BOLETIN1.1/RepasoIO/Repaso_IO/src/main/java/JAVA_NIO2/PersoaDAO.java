package JAVA_NIO2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersoaDAO {

    private static String archivoOrigen = "ProbasExercicio1.txt";
    private static String archivoDestino= "ProbasExercicioDestino.txt";


    //Metodo para copiar un archivo en otro

    public static void copiarArchivoConNIO(){
        try (FileReader fr = new FileReader(String.valueOf(Paths.get(archivoOrigen)));
             FileWriter fw = new FileWriter(String.valueOf(Paths.get(archivoDestino)));

             Files.walk(Paths.get(archivoOrigen),  new CopyOption(archivoOrigen, CopyOption.REPLACE_EXISTING);



    } {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
