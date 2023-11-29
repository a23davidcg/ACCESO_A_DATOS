package ImplementacionExamenParcial;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface IResultadosDAO {

    /**
     * Recoge la ruta a un archivo JSON y devuelve un objeto de tipo Resultados.
     * Emplea java.nio.file.Files y java.nio.file.Paths o java.nio.file.Path y flujos con buffer.
     *
     * @param ruta ruta completa al archivo JSON.
     * @return Resultados objeto de tipo Resultados.
     */
     Resultados getResultadosFromJSON(String ruta);


    /**
     * Recoge un objeto de tipo Resultados y lo guarda en un archivo de texto.
     * Simplemente, guarda el resultado del método toString() de la clase Resultados.
     * No emplees la clase PrintWriter. Usa Java IO.
     *
     * @param resultados objeto de tipo Resultados.
     * @param ruta       ruta completa al archivo de texto.
     * @return boolean true si se ha guardado correctamente, false en caso contrario.
     */
    boolean saveResultadosToTxt(Resultados resultados, String ruta);


    /**
     * Recoge un objeto de tipo Resultados y lo guarda en un archivo binario (serializado).
     * Puedes emplear Java IO o Java NIO.2
     * Emplea java.io.ObjectOutputStream y java.io.BufferedOutputStream.
     *
     * @param resultados objeto de tipo Resultados.
     * @param ruta       Ruta completa al archivo binario.
     * @return boolean
     */
    boolean saveResultadosToObject(Resultados resultados, String ruta);



    /**
     * Recoge la ruta a un archivo binario y devuelve un objeto de tipo Resultados.
     * Puedes emplear Java IO o Java NIO.2
     * Emplea java.io.ObjectInputStream y java.io.BufferedInputStream.
     *
     * @param ruta Ruta completa al archivo binario.
     * @return Resultados objeto de tipo Resultados.
     */
    Resultados getResultadosFromObject(String ruta);

}
