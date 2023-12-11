package ImplementacionExamenParcial;

import ImplementacionExamenParcial.Resultados;
import ImplementacionExamenParcial.ResultadosDAO;
import ImplementacionExamenParcial.parte1.AppArchivosJava;

public class AppResultados {

    public static final String RESULTADOS_JSON_FILE = "D:\\DAM 2\\AD\\ACCESO_A_DATOS\\UD01\\unidad1.1\\EjerciciosRepasoIO\\RepasoIO\\partidos.json";
    public static final String RESULTADOS_TXT_FILE = "partidos.txt";
    public static final String RESULTADOS_OBJECT_FILE = "partidos.dat";

    public static void main(String[] args) {
        ResultadosDAO resultadosDAO = new ResultadosDAO();

        Resultados reultados = resultadosDAO.getResultadosFromJSON(RESULTADOS_JSON_FILE);
        System.out.println("Los resultados del json son: " + reultados);

        Resultados result = new Resultados();

        String toTXT = String.valueOf(resultadosDAO.saveResultadosToTxt(result, RESULTADOS_TXT_FILE));
        String toObject = String.valueOf(resultadosDAO.saveResultadosToObject(result, RESULTADOS_OBJECT_FILE));

        String fromObject = String.valueOf(resultadosDAO.getResultadosFromObject( RESULTADOS_OBJECT_FILE));

        System.out.println(toTXT + toObject + fromObject);












    }
}
