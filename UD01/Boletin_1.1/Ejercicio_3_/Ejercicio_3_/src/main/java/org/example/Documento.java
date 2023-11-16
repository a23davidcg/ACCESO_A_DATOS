package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Documento {
    private File arquivo;
    private String nombre;

    public Documento(String nombre) {
        this.nombre = nombre;
    }

    public boolean exists() {
        File arquivo = new File("editor.txt");

        try {
            if (arquivo.exists()) {
                System.out.println("el archivo existe ");

            } else {
                System.out.println("el archivo no exite");

                Path path = Path.of("editor.txt");

                Files.createFile(path);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void readFile() {
        if (exists()) {
            try (BufferedReader br = new BufferedReader(
                    new FileReader("editor.txt"))) {

                StringBuilder sb = new StringBuilder();

                while ((sb = new StringBuilder(br.readLine())) != null) {
                    sb.append(br);
                    String textoLeido = sb.toString();
                    System.out.println(textoLeido);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("non existe arquivo para poder leelo. ");
        }
    }

    public void readFileNIO() {
        Path path1 = Paths.get("editor.txt");
        try {
            Files.readString(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeFromString() {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            try {
                System.out.println("introduce un texto para añadir al documento: ");

                String texto = br.readLine();

                System.out.println("El texto que se ha introducido es: " + texto);

                try (BufferedWriter bw = new BufferedWriter(
                        new FileWriter("editor.txt"))) {
                    bw.append(texto);
                    System.out.println("Se ha escritor en el editor.txt lo siguiente: " + texto);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFromStringPrintWriter(String cadena) {

        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter("editor.txt", true));
           // writer.write(cadena);
            writer.println(cadena);
            writer.close();
            System.out.println(cadena+ "ha sido añadida al documento ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeFromInputStream() {

        InputStreamReader reader = new InputStreamReader(System.in);

        try(OutputStream os = new FileOutputStream("editor.txt")){
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = reader.read())!= -1){
                os.write(buffer, 0, bytesRead);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeFromKeyword() {

    }

    public File getArquivo() {
        return arquivo;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "arquivo=" + arquivo +
                '}';
    }


}
