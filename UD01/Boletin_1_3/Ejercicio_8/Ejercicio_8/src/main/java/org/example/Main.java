package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Examen examenDatos = new Examen("examen", LocalDateTime.now(), Arrays.asList("Alberto, John, pedros"));

        ExamenDAO examenDAO = new ExamenDAO(examenDatos);

        examenDAO.writeToFile();
    }
}