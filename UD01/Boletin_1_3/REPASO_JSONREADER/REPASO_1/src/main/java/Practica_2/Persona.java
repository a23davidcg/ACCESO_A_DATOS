package Practica_2;

import java.util.Arrays;

public class Persona {
   private String[] nombres = {"Ana", "Pedro", "María"};

    public Persona(String[] nombres) {
        this.nombres = nombres;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombres=" + Arrays.toString(nombres) +
                '}';
    }
}
