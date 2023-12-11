package org.example;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        Ordenadores ordenadores = dao.getOrdenadoresFromJson("ordenadores.json");

        dao.saveOrdenadoresToObject(ordenadores, "ordenadores.bin");

        Ordenadores ordenadores2 = dao.getOrdenadoresFromObject("ordenadores.bin");

        System.out.println(ordenadores2);


    }
}