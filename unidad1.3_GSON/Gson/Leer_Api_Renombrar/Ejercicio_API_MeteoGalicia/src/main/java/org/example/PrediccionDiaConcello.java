package org.example;

public class PrediccionDiaConcello {
    private String dataPrediccion;
    private int nivelDeAviso;
    private int temperaturaMaxima;
    private int temperaturaminima;

    public PrediccionDiaConcello(String dataPrediccion, int nivelDeAviso, int temperaturaMaxima, int temperaturaminima) {
        this.dataPrediccion = dataPrediccion;
        this.nivelDeAviso = nivelDeAviso;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaminima = temperaturaminima;
    }

    public String getDataPrediccion() {
        return dataPrediccion;
    }

    public void setDataPrediccion(String dataPrediccion) {
        this.dataPrediccion = dataPrediccion;
    }

    public int getNivelDeAviso() {
        return nivelDeAviso;
    }

    public void setNivelDeAviso(int nivelDeAviso) {
        this.nivelDeAviso = nivelDeAviso;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(int temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public int getTemperaturaminima() {
        return temperaturaminima;
    }

    public void setTemperaturaminima(int temperaturaminima) {
        this.temperaturaminima = temperaturaminima;
    }

    @Override
    public String toString() {
        return "PrediccionDiaConcello{" +
                "dataPrediccion='" + dataPrediccion + '\'' +
                ", nivelDeAviso=" + nivelDeAviso +
                ", temperaturaMaxima=" + temperaturaMaxima +
                ", temperaturaminima=" + temperaturaminima +
                '}';
    }
}
