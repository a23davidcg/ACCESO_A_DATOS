/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.boletin00ad.tresenraia.tres_en_liña;

import com.pepinho.boletin00ad.tresenraia.tres_en_liña.Ficha;

import java.awt.Point;

/**
 *
 * @author pepe
 */
public class Tablero {

    private final Ficha[][] fichas;

    public static final int TAMANO = 3;

    public Tablero() {
        fichas = new Ficha[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                fichas[i][j] = new Ficha();
            }
        }
    }

    public static Point getCoordenadas(int indice) {
        if (indice < 0 || indice >= TAMANO * TAMANO) {
            return new Point(0, 0);
        }
        return new Point(indice / TAMANO, indice % TAMANO);
    }

    public boolean addFicha(int fila, int columna, Ficha ficha) {
        if (fila < 0 || fila >= TAMANO || columna < 0
                || columna >= TAMANO
                || (fichas[fila][columna] != null
                && !fichas[fila][columna].isEmpty())) {
            return false;
        }
        fichas[fila][columna] = ficha;
        return true;
    }

    public boolean isEmpty(int fila, int columna) {
        return fichas[fila][columna] == null
                || fichas[fila][columna].isEmpty();
    }

    public boolean isFull() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (fichas[i][j] == null || fichas[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(Ficha ficha) {
        // Comprobación filas
        for (int i = 0; i < TAMANO; i++) {
            if (fichas[i][0].equals(ficha) && fichas[i][1].equals(ficha)
                    && fichas[i][2].equals(ficha)) {
                return true;
            }
        }

        // Comprobación columnas
        for (int j = 0; j < TAMANO; j++) {
            if (fichas[0][j].equals(ficha) && fichas[1][j].equals(ficha)
                    && fichas[2][j].equals(ficha)) {
                return true;
            }
        }

        // Comprobar diagonales
        if (fichas[0][0].equals(ficha) && fichas[1][1].equals(ficha)
                && fichas[2][2].equals(ficha)) {
            return true;
        }
        return fichas[0][2].equals(ficha) && fichas[1][1].equals(ficha)
                && fichas[2][0].equals(ficha);
    }

    public Point getWinnerPosition() {

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (fichas[i][j] == null) {
                    sb.append("   ");
                } else {
                    sb.append(" ").append(fichas[i][j]).append(" ");
                }
                if (j < TAMANO - 1) {
                    sb.append("|");
                }
            }
            sb.append(System.lineSeparator());
            if (i < TAMANO - 1) {
                sb.append("-----------").append(System.lineSeparator());
            }
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

//    public void mostrarTablero() {
//        for (int i = 0; i < TAMANO; i++) {
//            for (int j = 0; j < TAMANO; j++) {
//                if (fichas[i][j] == null) {
//                    System.out.print("   ");
//                } else {
//                    System.out.print(" " + fichas[i][j] + " ");
//                }
//                if (j < TAMANO - 1) {
//                    System.out.print("|");
//                }
//            }
//            System.out.println();
//            if (i < TAMANO - 1) {
//                System.out.println("-----------");
//            }
//        }
//        System.out.println();
//    }
}
