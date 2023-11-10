import com.sun.tools.javac.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Equipos implements Comparable<Equipo> {
    String nombre;
    int victorias;
    int derrotas;
    int puntosFavor;
    int puntosContra;
    int puntos;


    //Constructor
    public Equipos(String nombre) {
        this.nombre = nombre;
    }

    public Equipos(String nombre, int puntos, int derrotas, int victorias, int puntosContra, int puntosFavor) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.derrotas = derrotas;
        this.victorias = victorias;
        this.puntosContra = puntosContra;
        this.puntosFavor = puntosFavor;
    }


    //Getters


    public String getNombre() {
        return nombre;
    }


    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPuntosFavor() {
        return puntosFavor;
    }

    public int getPuntosContra() {
        return puntosContra;
    }

    public int getPuntos() {
        return (puntosFavor - puntosContra);
    }


    public int compareTo(Equipos o) {

        if (this.getVictorias() > o.getVictorias()) {
            return 1;
        } else if (this.getVictorias() < o.getVictorias()) {
            return -1;

        } else {
            return 0;
        }
    }

    public static void equipos(String ficheiro, Equipos[] EquiposArray) {


        //Guardar los equipos en un fichero.dat


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro));//Se crea un objeto que se utiliza para escribir en el archivo especificado //FileWriter se utiliza paraabrir y gestionar el archivo en el sistema explorador de archivos
            for (Equipos equipo : EquiposArray) {
                String equipoInfo = String.format("%20s, %2d, %2d, %2d, %2d ,%2d", equipo.nombre, equipo.puntos, equipo.victorias, equipo.puntosContra, equipo.puntosFavor); //Se le da formato a los datos que se obtienen, despues del %, por ejemplo en las d se le da la cantidad de decimales que deben de mostrarse
                bw.write(equipoInfo);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        public static void main (String[]args){
            //Creamos un treeSet
            Set<Equipos> equipoSet = new TreeSet<>();

            //añadimos equipos al TreeSet
            equipoSet.add(new Equipos("Barcelona:", 10, 2, 8, 20, 30));
            equipoSet.add(new Equipos("Madrid:", 8, 3, 7, 25, 35));

            //Se ordenan los equipos de forma automatica
            for (Equipos equipo : equipoSet) {
                System.out.println(equipo.getNombre() + "-Victorias" + equipo.getVictorias());
            }

            /*Equipos [] EquiposArray = new Equipos[]{
                    new Equipos("Barcelona:", 10, 2, 8, 20, 30),
                    new Equipos("Madrid:", 8, 3, 7,25,35),

            };*/
        }
       /* public int hashCode(Object obj){
            if (this ==obj){
                return true;
            }
            if (obj == null || !(objinstanceOf Equipo)){
                return false;
            }
            return this.nome.equalsIgnorecase
        }*/


    }

    @Override
    public int compareTo(Equipo o) {
        return 0;
    }
}
