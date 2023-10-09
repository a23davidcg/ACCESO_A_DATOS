package com.pepinho.boletin00ad.tresenraia.tres_en_liña;

import java.io.FileNotFoundException;
import java.util.Random;

public class Game {
    Tablero tablero;
    TipoFicha tipojugador;
    Scanner teclado;

    public Game() {
        this.tablero = new Tablero();
        Random r = new Random();
        if (r.nextInt(2) == 0) { //Devuelve 0 o uno, asignandole en las siguietnes lineas par aun valior cada cosa, cruz o circulo
            tipojugador = TipoFicha.CRUZ;
        } else {
            tipojugador = TipoFicha.CIRCULO;
        }

    }


    /*public static void main (String args []) throws FileNotFoundException {
        Random xerador = new Random(0); //No caso que sempre queiramos mostrar a mesma secuencia de numeros para cada usuario como e o caso do dni, que semore se mostre o mesmo para o mesmo usuario.
        int i;
        for (int i ; j< 10; j++){
            System.out.println(xerador.nextInt(2));
        }

        System.out.println("xerador.nextInt() = " + xerador.nextInt());*/


}
