package SerializacionYDeserializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Para leer objetos del fichero
        //DEbemos de crear un File para poder leer los objetos del fichero
        //Lo envoolvemos en un FileInputSteream para crear el flijo de datos
        //Lo envolvemos en un objeectInputStream para poder los objetos del flujo de datos
        //usaremos el metodo readObject que devolvera un object que debemos de convertir al tipo de la clase objeto, haremos un casting. Dicho metodo ademas puede lanzar una excepciuon adicional del tipo de ClssNotFounfException
        Grupo dam = null;

        try {
            FileInputStream fis = new FileInputStream("archivo.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dam = (Grupo) ois.readObject();
            ois.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
