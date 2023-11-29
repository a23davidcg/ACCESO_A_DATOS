package org.example;

import java.io.File;

public class Ejercicio4 {
    public static void main(String[] args) {
        //Se pide crear un metodo que reciba una carpeta y liste el  contenido de dicha carpeta de aqeullos archivos cuya extension
        //sea .txt Crea una sobrecarga para que el metodo reciba el tipo de archivo a listar

        listararchivos(".txt", "D:\\DAM 2\\AD\\ACCESO_A_DATOS\\UD01\\unidad1.1\\EjerciciosRepasoIO\\RepasoIO");


    }

    public static void listararchivos(String extensionFicheros, String ruta) {
        File carpeta = new File(ruta);
        System.out.println(("La ruta que se ha introducido para verificare los archivos es: ").toUpperCase() + carpeta.getAbsolutePath());

        if (carpeta.isDirectory()) {
            File[] files = carpeta.listFiles(((dir, name) -> name.toLowerCase().endsWith(extensionFicheros.toLowerCase())));

            if (files != null) {
                if (files.length > 0) {
                    for (File f : files) {
                        System.out.println("Archivo encontrado " + f.getName());

                    }
                } else {
                    System.out.println("No se ha encontardo ningun fichero con la extension " + extensionFicheros);
                }
            } else {
                System.out.println("Archivos no encontrados");
            }
        }
    }
}


