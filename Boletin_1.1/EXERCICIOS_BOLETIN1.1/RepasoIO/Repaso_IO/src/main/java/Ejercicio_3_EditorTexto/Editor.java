package Ejercicio_3_EditorTexto;

public class Editor {

    public static void main(String[] args) {
        Documento docu = new Documento("ProbasExercicio1.txt");
        docu.readFile();

        System.out.println(docu.readFile());

        docu.writeFromInputStream();


    }


}
