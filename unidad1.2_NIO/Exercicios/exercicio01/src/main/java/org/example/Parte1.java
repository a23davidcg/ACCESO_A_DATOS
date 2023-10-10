package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parte1 {
    public static void main(String[] args) {
        //Escribe un prgorama que compruebe si una ruta de archivo es absoluta o relativa y si existe
        //Escribe un programa qu ecopie un archivo en otro sustituyendolo si existe y lo mueva un archivo de una ubicacion a ora empleando Files
        //Crea un programa que recoja una ruta de archivp como entrada del usuario (JFilechooser, y muestre el nombre del archivo y su extension en una nueva ventana emergente (JOptionPane.Crea un path y recupera la posicion a partir del nombre del archivo(emplealastindexof)


        //PARTE 1
        Path p = Paths.get("D:\\MaquinasVirtuais\\AD\\unidad1.2\\Exercicios\\exercicio01\\proba.dat");

        if(Files.exists(p) && p.isAbsolute()){
            System.out.println("la ruta existe y es absoluta");
        }else {
            System.out.println("la ruta es relativa");
        }
    }
}