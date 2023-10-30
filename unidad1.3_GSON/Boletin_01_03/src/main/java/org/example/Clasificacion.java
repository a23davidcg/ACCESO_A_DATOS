package org.example;

public class Clasificacion {
    private String nome;
    private int jugados;
    private int victorias;
    private int derrotas;
    private int puntosFavor;
    private int puntosContra;

    public Clasificacion(String nome, int jugados, int victorias, int derrotas, int puntosFavor, int puntosContra) {
        this.nome = nome;
        this.jugados = jugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntosFavor = puntosFavor;
        this.puntosContra = puntosContra;
    }

    public String getNome() {
        return nome;
    }

    public int getJugados() {
        return jugados;
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

    @Override
    public String toString() {
        return "Clasificacion{" +
                "nome='" + nome + '\'' +
                ",\n jugados=" + jugados +
                ",\n victorias=" + victorias +
                ",\n derrotas=" + derrotas +
                ",\n puntosFavor=" + puntosFavor +
                ",\n puntosContra=" + puntosContra +
                '}';
    }
}
