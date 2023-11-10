package org.example;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Chuvia {

    @Expose(serialize = true, deserialize = true)
    private double cantidade;

    //private double cantidade;
    private String nome;

    public Chuvia(double cantidade, String nome) {
        this.cantidade = cantidade;
        this.nome = nome;
    }




    public double getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Chuvia{" +
                "cantidade=" + cantidade +
                ", nome='" + nome + '\'' +
                '}';
    }
}
