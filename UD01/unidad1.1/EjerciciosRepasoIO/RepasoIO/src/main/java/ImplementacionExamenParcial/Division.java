package ImplementacionExamenParcial;

import java.util.Arrays;

public enum Division {

    ATLANTIC("Atlantic"),
    CENTRAL("Central"),
    SOUTHEAST("Southeast"),
    NORTHWEST("Northwest"),
    PACIFIC("Pacific"),
    SOUTHWEST("Southwest");


    private final String nombre;

    Division(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Division getDivision(String nombre) {
        // Con expresión lambda
        return Arrays.stream(Division.values()).filter(division -> division.getNombre().equals(nombre)).findFirst().orElse(null);

/*        COn bucle for:

//for (Division division : Division.values()) {
//            if (division.getNombre().equals(nombre)) {
//                return division;
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
