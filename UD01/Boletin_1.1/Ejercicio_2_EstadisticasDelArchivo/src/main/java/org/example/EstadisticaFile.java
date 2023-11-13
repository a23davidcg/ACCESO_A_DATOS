package org.example;

import java.io.File;

public class EstadisticaFile {
    private String letras;
    private int linhas;
    private int espacios;
    private File archivo;

    public EstadisticaFile(String letras, int linhas, int espacios, File archivo) {
        this.letras = letras;
        this.linhas = linhas;
        this.espacios = espacios;
        this.archivo = archivo;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "EstadisticaFile{" +
                "letras='" + letras + '\'' +
                ", linhas=" + linhas +
                ", espacios=" + espacios +
                ", archivo=" + archivo +
                '}';
    }
}
