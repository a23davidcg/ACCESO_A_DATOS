package Ejercicio_3_EditorTexto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            try (FileInputStream fis = new FileInputStream(this.arquivo);
                 BufferedInputStream bis = new BufferedInputStream(fis)) {

                StringBuilder sb = new StringBuilder();

                int byteLeido;
                while ((byteLeido = bis.read()) != -1) {
                    sb.append(byteLeido);
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

    public void writeFromInputStream(){


        try (InputStream is = System.in; //Collemos a entrada de datos
        OutputStream os = new FileOutputStream(this.arquivo)){ //indicamos en donde se van a escribir esos datos

            int datosLeidos; //Metemos os datos nunha vriable

            while ((datosLeidos = is.read()) != -1){ //Mentres teña datos para leer, iraos escribindo no archivo de
                os.write(datosLeidos); // Ir escribindo mentres  tanto 
            }

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






