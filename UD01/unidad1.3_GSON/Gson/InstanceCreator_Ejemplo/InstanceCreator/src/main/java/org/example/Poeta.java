package org.example;

public class Poeta {

    private int edad;
    private String nome;

    private String categoria;

    public Poeta() {
    }

    public Poeta(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Poeta{" +
                "edad=" + edad +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
