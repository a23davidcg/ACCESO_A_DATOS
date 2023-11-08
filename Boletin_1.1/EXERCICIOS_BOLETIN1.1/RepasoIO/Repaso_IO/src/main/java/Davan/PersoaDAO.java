package Davan;

import java.io.*;

public class PersoaDAO {

    private static final String ARCHIVO = "ProbasExercicio1.txt";

    public static void writeFileTXT(Persoa p){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(ARCHIVO)));

            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerArchivo(Persoa p){
        try(ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(ARCHIVO)))) {

            ois.read();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
