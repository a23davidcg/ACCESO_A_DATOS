package SerializacionYDeserializacion;

import java.io.*;

public class Ejercicio1 implements Serializable {

    /*Debesmos de crear un File para almecenar objetos
     * envolverlo en un FileOutputStream para crear el flijo de datos
     * lo envolvemos todo en un objectoutputStream para poder escribit los obhjetos en un flujo de datos
     *                usamos el metodo writeobjewct
     * */
    public static void main(String[] args) {
        Grupo dam = new Grupo("1DAM");

        try{
            FileOutputStream fos = new FileOutputStream("Archivo.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dam);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static class Grupo {
        private String nombre;


        public Grupo(String nombre) {
            this.nombre = nombre;

        }
    }
}
