package ImplementacionExamenParcial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Resultados implements java.io.Serializable {

    private List<Partido> partidos;

    public Resultados() {
        partidos = new ArrayList<>();
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    public void saveResultados(String filename) {
        //
        try(var bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(this.toString());
        } catch (Exception e) {
            System.out.println("Error al guardar los resultados: " + e.getMessage());
        }
    }

    public void ordenarPorFecha() {
        partidos.sort(Comparator.comparing(Partido::getFecha));
    }

    public void sort(){
        Collections.sort(partidos);
    }

    @Override
    public String toString() {
        return partidos.stream().map(Partido::toString)
                .reduce("", (s, s2) -> s  + s2 + System.lineSeparator());
    }
}
