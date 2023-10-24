package org.example;

public class Main {
    public static void main(String[] args) {

        //TODO: probamos que todos os metodos funcionan de forma correcta

        SudokuDAO dao = new SudokuDAO();

        Sudoku sudoku = new Sudoku(); //FIXME: revisar esta parte para poder ver si os metodos funcionan

        dao.saveToJson(sudoku);

        Sudoku sudoku1 = dao.getFromJSON();

        dao.saveToJson(sudoku1, "outro.json");

        Sudoku sudoku2 = dao.getFromJSON("outro.json");




    }
}