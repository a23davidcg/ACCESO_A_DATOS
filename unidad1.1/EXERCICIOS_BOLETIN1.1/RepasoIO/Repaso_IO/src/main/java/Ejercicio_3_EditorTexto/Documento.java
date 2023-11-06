package Ejercicio_3_EditorTexto;

import java.io.*;

public class Documento {

    private File arquivo;
    private String nombre;

    public Documento(String nombre) {
        this.nombre = nombre;
    }

    public Documento(File arquivo) {
        this.arquivo = arquivo;
    }

    public boolean exists(){
        if (arquivo.exists() && arquivo !=null){
            return true;
        }else {
            return false;
        }
    }

    public String readFile(){
        StringBuilder stringBuilder = new StringBuilder();

        try{
        FileReader reader = new FileReader("ProbasExercicio1.txt");
            BufferedReader br = new BufferedReader(reader);

            stringBuilder.append(br.readLine());
        } catch (IOException e) {

        }
    }

    public String readFileNIO(){

    }

    public String writeFromString(){
        return writeFromString();

    }

    public String writeFromKeyBoard(){
        return writeFromKeyBoard();
    }

    public Object getFile(){
        return Object;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "arquivo=" + arquivo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
