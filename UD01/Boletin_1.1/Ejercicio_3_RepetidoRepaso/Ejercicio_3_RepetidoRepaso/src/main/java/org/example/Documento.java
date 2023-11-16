package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Documento {

    private static File arquivo ;
    private String nome;

    public Documento(String nome) {
        this.nome = nome;
    }

    public Documento(File arquivo) {
        this.arquivo = arquivo;
    }

    public static boolean exists() {
        File file = new File("editor.txt");

        try {
            if (file.exists()) {
                return true;
            } else {
                System.out.println("O arquivo non existe, procedeuse  crear un novo. ");
                Path path = Path.of("editor.txt");

                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return exists();
    }

    public static void readFile() {
        if (exists()) {
            try (BufferedReader reader = new BufferedReader(
                    new FileReader("editor.txt"))) {

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    System.out.println("IO: " + sb);
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void readFileNIO() {
        Path path = Path.of("editor.txt");
        if (exists()) {
            try {
                String lineas = Files.readString(path);
                System.out.println("NIO: " + lineas);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("non existe o archivo");
            exists();
        }
    }

    public static void writeFromString() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                System.out.println("introduce o texto que queiras engadir ao ficheiro: ");

                String texto = br.readLine();

                System.out.println("Introduciuse: " + texto);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("editor.txt", true))) {

                    bw.append(texto);
                    bw.flush();

                    System.out.println("escribiuse: " + texto);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFromPrintWriter(String cadena) {

        try (PrintWriter pw = new PrintWriter(
                new FileWriter("editor.txt", true))) {

            pw.append(cadena);
            pw.flush();
            System.out.println("FromPrintWriter: " + cadena);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile() {
        System.out.println("getFile " + arquivo);
        return arquivo;

    }

    @Override
    public String toString() {
        return "Documento{" +
                "arquivo=" + arquivo +
                '}';
    }
}
