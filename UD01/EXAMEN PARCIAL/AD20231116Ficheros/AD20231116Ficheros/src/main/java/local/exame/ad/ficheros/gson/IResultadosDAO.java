package local.exame.ad.ficheros.gson;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface IResultadosDAO {
    Resultados resultados = new Resultados();

    Gson gson = new Gson();
    String json = gson.toJson(resultados);


    /**
     * Recoge la ruta a un archivo JSON y devuelve un objeto de tipo Resultados.
     * Emplea java.nio.file.Files y java.nio.file.Paths o java.nio.file.Path y flujos con buffer.
     *
     * @param ruta ruta completa al archivo JSON.
     * @return Resultados objeto de tipo Resultados.
     */
    // Resultados getResultadosFromJSON(String ruta);
    public static Resultados getResultadosFromJSON(String ruta) {//FIXME:OLLO REVISAR METODO
        try {
            byte[] archivo = Files.readAllBytes(Paths.get(ruta));
            ByteArrayInputStream bis = new ByteArrayInputStream(archivo);

            try (ObjectInputStream ois = new ObjectInputStream(bis)) {
                return (Resultados) ois.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Recoge un objeto de tipo Resultados y lo guarda en un archivo de texto.
     * Simplemente, guarda el resultado del método toString() de la clase Resultados.
     * No emplees la clase PrintWriter. Usa Java IO.
     *
     * @param resultados objeto de tipo Resultados.
     * @param ruta       ruta completa al archivo de texto.
     * @return boolean true si se ha guardado correctamente, false en caso contrario.
     */
    //boolean saveResultadosToTxt(Resultados resultados, String ruta);
    public static boolean saveResultadosTotxt(Resultados resultados, String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ruta))) {
            oos.writeObject(resultados);
            System.out.println("obxeto gardado en" + ruta);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    /**
     * Recoge un objeto de tipo Resultados y lo guarda en un archivo binario (serializado).
     * Puedes emplear Java IO o Java NIO.2
     * Emplea java.io.ObjectOutputStream y java.io.BufferedOutputStream.
     *
     * @param resultados objeto de tipo Resultados.
     * @param ruta       Ruta completa al archivo binario.
     * @return boolean
     */
    //boolean saveResultadosToObject(Resultados resultados, String ruta);
    public static boolean saveResultadosToObject(Resultados resultados, String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ruta))) {
            oos.writeObject(resultados);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }


    /**
     * Recoge la ruta a un archivo binario y devuelve un objeto de tipo Resultados.
     * Puedes emplear Java IO o Java NIO.2
     * Emplea java.io.ObjectInputStream y java.io.BufferedInputStream.
     *
     * @param ruta Ruta completa al archivo binario.
     * @return Resultados objeto de tipo Resultados.
     */
    Resultados getResultadosFromObject(String ruta);

    public static void getResultadosFromObject() {
        Path arquivoPath = Paths.get("resultados.txt");
        byte[] contido = Files.readAllBytes(arquivoPath);

        ByteArrayInputStream bis = new ByteArrayInputStream(contido);

        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            Resultados resultado = (Resultados) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
