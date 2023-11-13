package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ruta {

    String orixe = "orixe.txt";
    String destino = "Destino.txt";

    Path path = Paths.get(orixe);
    Path path1 = Paths.get(destino);




    public void saberRutaAbsoluta() {
        if (path.isAbsolute()) {
            System.out.println("La ruta es absoluta");
        } else {
            System.out.println("La ruta es relativa");
        }
    }

    public  void copiarArchivo () {
        try {
            Files.copy(path, path1, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("copiouse o contido do archivo de orixe, sustituindo o contido do archivo de destino ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void moverArchivo() {
        try {
            Files.move(path, path1, StandardCopyOption.ATOMIC_MOVE);
            System.out.println("Moveuse o ficheiro de orixe para o de destino ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
