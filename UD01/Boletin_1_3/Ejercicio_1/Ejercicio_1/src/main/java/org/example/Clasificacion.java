package org.example;

public class Clasificacion {
    private String equipo;
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private int puntosAFavor;
    private int puntosContra;
    private int diferenciaPuntos;

    public Clasificacion(String equipo, int partidosJugados, int victorias, int derrotas, int puntosAFavor, int puntosContra, int diferenciaPuntos) {

        this.equipo = equipo;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntosAFavor = puntosAFavor;
        this.puntosContra = puntosContra;
        this.diferenciaPuntos = diferenciaPuntos;
    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "equipo='" + equipo + '\'' +
                ", partidosJugados=" + partidosJugados +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", puntosAFavor=" + puntosAFavor +
                ", puntosContra=" + puntosContra +
                ", diferenciaPuntos=" + diferenciaPuntos +
                '}';
    }
}
