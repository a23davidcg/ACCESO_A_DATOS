package org.example;

import java.util.List;

public class PrediccionConcello {
    private int idConcello;
    private String nome;
    //private List<PrediccionDiaConcello> prediccionDiaConcello;


    public PrediccionConcello(int idConcello, String nome) {
        this.idConcello = idConcello;
        this.nome = nome;
    }

    public PrediccionConcello() {
    }

    public int getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(int idConcello) {
        this.idConcello = idConcello;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
