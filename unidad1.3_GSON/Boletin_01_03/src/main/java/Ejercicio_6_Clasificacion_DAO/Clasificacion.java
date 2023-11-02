package Ejercicio_6_Clasificacion_DAO;

public class Clasificacion {
    private String nome;
    private int puntos;
    private int partidosJugados;

    public Clasificacion(String nome, int puntos, int partidosJugados) {
        this.nome = nome;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
}
