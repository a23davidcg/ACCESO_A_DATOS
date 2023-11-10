package com.pepinho.ad.codigopostal.view;

import com.pepinho.ad.codigopostal.control.ICodigoPostalController;

import java.util.Scanner;

public class VistaTextoCodigoPostal implements IVistaCodigoPostal{

    public static final Scanner sc = new Scanner(System.in);

    private ICodigoPostalController controller;
    private StringBuilder lugares;

    public VistaTextoCodigoPostal(ICodigoPostalController controller) {
        this.controller = controller;
        lugares = new StringBuilder();
    }

    private void mostrarMenu() {
        System.out.println("1. Consultar código postal");
        System.out.println("2. Salir");
    }

    private void mostrarMenuConsulta() {
        System.out.println("1. Consultar por código postal");
        System.out.println("2. Consultar por por país y código postal");
        System.out.println("3. Consultar por lugar");
        System.out.println("4. Volver");
    }

    private void mostrarMenuLugar() {
        System.out.println("1. Consultar por provincia");
        System.out.println("2. Consultar por municipio");
        System.out.println("3. Consultar por calle");
        System.out.println("4. Volver");
    }

    private void mostrarMenuHTML() {
        System.out.println("¿Desea mostrar los lugares como HTML? (s/n)");
    }

    public void show() {
        mostrarMenu();

        int opcion = sc.nextInt();

        while ((opcion < 1) || (opcion > 2)) {
            System.out.println("Opción incorrecta");
            mostrarMenu();
            opcion = sc.nextInt();
        }

        while (opcion != 2) {
            mostrarMenuConsulta();
            opcion = sc.nextInt();
            while ((opcion < 1) || (opcion > 3)) {
                System.out.println("Opción incorrecta");
                mostrarMenuConsulta();
                opcion = sc.nextInt();
            }
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el código postal");
                    String cp = sc.next();

                    System.out.println("¿Desea mostrar los lugares como HTML? (s/n)");
                    String html = sc.next();

                    while (!html.equalsIgnoreCase("s") && !html.equalsIgnoreCase("n")) {
                        System.out.println("Opción incorrecta");
                        System.out.println("¿Desea mostrar los lugares como HTML? (s/n)");
                        html = sc.next();
                    }

                    setLugares(controller.getLugares(cp, html.equalsIgnoreCase("s")));
                    System.out.println(toString());
                    break;
                case 2:
                    System.out.println("Introduce el código postal");
                    cp = sc.next();
                    System.out.println("Introduce el país");
                    String pais = sc.next();
                    System.out.println("¿Desea mostrar los lugares como HTML? (s/n)");
                    html = sc.next();
                    while (!html.equalsIgnoreCase("s") && !html.equalsIgnoreCase("n")) {
                        System.out.println("Opción incorrecta");
                        System.out.println("¿Desea mostrar los lugares como HTML? (s/n)");
                        html = sc.next();
                    }
                    setLugares(controller.getLugares(cp, pais, html.equalsIgnoreCase("s")));
                    System.out.println(toString());
                    break;
                case 3:
                    System.out.println("No implementado");
                    break;
            }
        }
    }

    @Override
    public void mostrarError(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void addLugar(String lugar) {
        lugares.append(lugar);
    }

    @Override
    public void deleteLugares() {
        lugares.delete(0, lugares.length());
    }

    @Override
    public void setLugares(String lugares) {
        deleteLugares();
        this.lugares.append(lugares);
    }

    @Override
    public void setController(ICodigoPostalController controller) {
        this.controller = controller;
    }

    @Override
    public void mostrar() {
        show();
    }

    @Override
    public String toString() {
        return lugares.toString();
    }
}
