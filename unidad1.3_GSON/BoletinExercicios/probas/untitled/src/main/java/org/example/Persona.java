package org.example;

public class Persona {
    public int edad;
    public String nombre;

    public Persona(String nombre, int edad) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public Persona persona(Persona persona){
        return persona;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + edad;
    }
}
