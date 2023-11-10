package org.example;

public class Prediccion {
    private PrediccionConcello prediccionConcello;

    public Prediccion(PrediccionConcello prediccionConcello) {
        this.prediccionConcello = prediccionConcello;
    }

    public Prediccion() {
    }

    public PrediccionConcello getPrediccionConcello() {
        return prediccionConcello;
    }

    public void setPrediccionConcello(PrediccionConcello prediccionConcello) {
        this.prediccionConcello = prediccionConcello;
    }
}
