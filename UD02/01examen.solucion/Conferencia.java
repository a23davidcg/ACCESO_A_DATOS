package com.pepinho.ad.ud01.gson;

import java.util.Arrays;

public enum Conferencia {
    EAST("East"),

    WEST("West");

    private final String nombre;

    private Conferencia(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public static Conferencia getConferencia(String nombre) {
        // Con expresión lambda:
        return Arrays.stream(Conferencia.values()).filter(conferencia -> conferencia.getNombre()
                .equals(nombre)).findFirst().orElse(null);

/*        // Con bucle for:
//for (Conferencia conferencia : Conferencia.values()) {
//            if (conferencia.getNombre().equals(nombre)) {
//                return conferencia;
//            }
//        }
//        return null;
        */
    }

    @Override
    public String toString() {
        return nombre;
    }
}
