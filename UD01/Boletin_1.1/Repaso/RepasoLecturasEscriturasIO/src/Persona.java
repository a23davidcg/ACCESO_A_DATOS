import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Persona {
    private String nombre;
    private int edad;
    private String apellidos;


    public Persona(String nombre, int edad, String apellidos) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    /*public static void ecribirArchivo(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ProbasEscritura.txt"))){
            String linea =null ;

            bw.write(linea);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}