package Ejercicio_3_EditorTexto;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Documento {

    private File arquivo;

    public Documento(String nombre) {
        this.arquivo = new File(nombre);
    }

    public Documento(File arquivo) {
        this.arquivo = arquivo;
    }


    //IMPLEMENTACION DE LOS METODOS


    public boolean exists() {
        if (arquivo != null && arquivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String readFile() {

        if (this.exists()) {
//            try (FileInputStream fis = new FileInputStream(this.arquivo);
//                 BufferedInputStream bis = new BufferedInputStream(fis)) {
            try (BufferedReader bis = new BufferedReader(new FileReader(this.arquivo))) {

                StringBuilder sb = new StringBuilder();

                String line;
                while ((line = bis.readLine()) != null) {
                    sb.append(line).append(System.lineSeparator());
                }
                return sb.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "";
        }
    }

    public String readFileNIO() {
        if (this.exists()) {
            String contenido = null;
            try {
                contenido = Files.readString((this.arquivo.toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return contenido;

        } else {
            return "";
        }
    }

    //todo: continuar desde aqui.

    public void writeFromString(String cadena) {
        if (this.exists()) {
            try (FileWriter fw = new FileWriter(this.arquivo);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write(cadena);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writeFromStringPrintWriter(String Cadena) {

        try (PrintWriter pw = new PrintWriter(this.arquivo);
             BufferedWriter bw = new BufferedWriter(pw)) {

            bw.write(Cadena);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFromInputStream() {

        try (InputStream is = System.in; //Collemos a entrada de datos
             BufferedReader br = new BufferedReader(new FileReader(this.arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(this.arquivo))) { //indicamos en donde se van a escribir esos datos

            StringBuilder sb = new StringBuilder(br.read());

            int datosLeidos; //Metemos os datos nunha vriable
            String line;
            while ((line = br.readLine()) != null) { //Mentres teña datos para leer, iraos escribindo no archivo de
                sb.append(line).append(System.lineSeparator());

                // Ir escribindo mentres  tanto
            }
            while ((datosLeidos = is.read()) != -1) { //Mentres teña datos para leer, iraos escribindo no archivo de
                sb.append(datosLeidos);

                // Ir escribindo mentres  tanto
            }
            bw.write(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeFromKeyBoard(String texto) {
        Scanner sc = new Scanner(System.in);
        String contenido = sc.nextLine();

        this.writeFromString(contenido);

    }


//    public String writeFromInputStream() {
//        try {
//            ObjectInputStream ois = new ObjectInputStream(
//                    new BufferedInputStream(
//                            new FileInputStream(String.valueOf(Paths.get("probasCopia.txt")))));
//            System.out.println(ois);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }


    public String writeFromKeyBoard() {
        return writeFromKeyBoard();
    }

}






