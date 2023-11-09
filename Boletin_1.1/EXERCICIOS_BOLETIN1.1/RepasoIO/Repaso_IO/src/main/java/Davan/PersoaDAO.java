package Davan;

import java.io.*;
import java.util.Scanner;

public class PersoaDAO {

    private static final String ARCHIVO = "ProbasExercicio1.txt";
    private static final String ARCHIVODESTINO = "ProbasExercicioDestino.txt";

   /* public static void writeFileTXT(Persoa p){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(ARCHIVO)));

            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerArchivo(Persoa p){
        try(ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(ARCHIVO)))) {

            ois.read();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    public static void leerArchivoIO() {
        try (BufferedReader br = new BufferedReader(
                new FileReader(ARCHIVO))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public static void copiaArchiv0() {
        try (BufferedReader br = new BufferedReader(
                new FileReader(ARCHIVO));
             BufferedWriter bw = new BufferedWriter(
                     new FileWriter(ARCHIVODESTINO))) {

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escrbirPorTecladoEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArquivotextoTeclado.txt", true))) {

            String line;

            System.out.println("Escribe o que queiersas gardar no arquivo: ");
            Scanner sc = new Scanner(System.in);

            while ((line = sc.nextLine()) != null) {
                bw.append(line);//Podriamos sustituilo por un write xa qu efunciona do mesmo xeito
                bw.newLine();//Escribir nunha nova liña
                sc.close();//Cerramos o scanner

                bw.close(); //Para que no se me sobrescriba el texto que tiene ya por defecto el txt
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void contarPalabrasArchivo() {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("ProbasExercicio1.txt"))) {
            String line;

            while ((line= br.readLine()) != null) {
                String[] palabras = line.split(" ");
                contador += palabras.length;

                System.out.println(contador );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
