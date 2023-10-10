package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;

public class Parte3 {
    public static void main(String[] args) {
        /*Lista el contenido de un  programa que muestre el listado del contenido de un directorio de diferentes modos
        a) Liste el contenido de todos los archivos y directorios de un acarpeta dada con el metodo listFiles() de file, pero a partir de un path
        b) De manera recursiva muestre todo el contenido es un subdrectorio*/

        //Crear el programa java que recoja la ruta de un archivp como entrada del usuario (JFileChooser, y muestre el nombre del archivo y su extension en

        JFileChooser fileChooser = new JFileChooser();//File chooser para abrir la venta en la que se va a seleccionar el archivo
        fileChooser.showOpenDialog(fileChooser);
        try {
            String ruta = fileChooser.getSelectedFile().getName();
            JLabel etiqueta = new JLabel("El nombre es:" + ruta );
            etiqueta.setFont(new Font("Arial", Font.BOLD, 100)); //Darle formato al texto que aparece en la ventaja emergente
            JOptionPane.showMessageDialog(null, etiqueta, "Ruta",  JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String nome = path.getFileName().toString();
        int posPunto = nome.lastIndexof(".");


    }
}
