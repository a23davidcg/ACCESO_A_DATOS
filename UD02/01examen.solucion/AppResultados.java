package com.pepinho.ad.ud01.gson;

public class AppResultados {

    public static final String RESULTADOS_JSON_FILE = "e:\\partidos.json";
    public static final String RESULTADOS_TXT_FILE = "e:\\partidos.txt";
    public static final String RESULTADOS_OBJECT_FILE = "e:\\partidos.dat";

    public static void main(String[] args) {

        ResultadosDAO dao = new ResultadosDAO();

        Resultados resultados = dao.getResultadosFromJSON(RESULTADOS_JSON_FILE);
        System.out.println(resultados);

        dao.saveResultadosToTxt(resultados, RESULTADOS_TXT_FILE);
        dao.saveResultadosToObject(resultados, RESULTADOS_OBJECT_FILE);

        resultados = dao.getResultadosFromObject(RESULTADOS_OBJECT_FILE);
        System.out.println(resultados);

    }
}
