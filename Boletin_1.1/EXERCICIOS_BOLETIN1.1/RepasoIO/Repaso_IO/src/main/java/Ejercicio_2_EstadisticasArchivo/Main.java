package Ejercicio_2_EstadisticasArchivo;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        //Realizar un programa que recoja el nombre de un fichero y muestre una estaidistica de la ruta, numero de lineas, numero de espacios, numero de letras, fecha de ultima modificacion, longitud del fichero
        //Debemos de definir un clase con los atributos  de letras, linhas, espacios, archivo tipo File

        EstadisticaFile estadistica = new EstadisticaFile();
        estadistica.calcularEstadisticas();
    }
}