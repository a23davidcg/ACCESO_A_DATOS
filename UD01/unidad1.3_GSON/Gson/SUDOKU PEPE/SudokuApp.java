/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.sodoku;


import java.util.List;


/**
 * 1234 3412 4123 2341
 *
 * @author pepecalo
 */
public class SudokuApp {

    public static void main(String[] args) throws Exception {

        Sudoku sudo = Sudoku.loadSudokuFromTXT("e:\\sudokuSolver.txt");
        System.out.println(sudo);
        System.out.println("sudo.isCompleted() = " + sudo.isCompleted());
        System.out.println("sudo.isValid() = " + sudo.isValid());
        List<Sudoku> sudos = sudo.getChildren();
        if(sudos!=null)
        for (Object sudo1 : sudos) {
            System.out.println(sudo1);
        }

    }
}
