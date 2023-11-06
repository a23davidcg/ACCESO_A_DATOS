package Ejercicio_2_EstadisticasArchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EstadisticaFile {

    private File arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstadisticaFile() {
    }

    public File getArquivo() {
        return arquivo;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getLetras() {
        return letras;
    }

    public int getEspazos() {
        return espazos;
    }

    public void calcularEstadisticas() {

        try {
            FileReader reader = new FileReader("ProbasExercicio1.txt");
            BufferedReader br = new BufferedReader(reader);


            //POÑEMOS OS CONTADORES A 0 PARA PODER INICIAR A CONTA

            int contadorDeCaracteres = 0;
            int contadorLinhas = 0;
            int contadorEspacios = 0;

            String linha;

            while ((linha = br.readLine()) != null) {
                contadorDeCaracteres += linha.length();

                contadorLinhas++;

                contadorEspacios += linha.length() - linha.replaceAll(" ", "").length();
            }

            //Estadisticas finales
            letras = contadorDeCaracteres;
            linhas = contadorLinhas;
            espazos = contadorEspacios;


            br.close();

            //Solo o fai para a

            System.out.println("Ten " + letras + " letras "  + "\n"+  linhas + " liñas" + "\n" + espazos + " espazos");

        } catch (IOException e) {
            System.out.println("ERRO ao leer o arquivo " + e.getMessage());
        }
    }
}
