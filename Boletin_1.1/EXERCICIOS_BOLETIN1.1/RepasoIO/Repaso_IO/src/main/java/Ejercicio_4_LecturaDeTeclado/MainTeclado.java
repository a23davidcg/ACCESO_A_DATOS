package Ejercicio_4_LecturaDeTeclado;

import java.sql.SQLOutput;

public class MainTeclado {
    public static void main(String[] args) {

        Teclado teclado = new Teclado();


        System.out.println("introduce una cadena: ");
        String inputString = teclado.lerString();

        System.out.println("La cadena que se ha introducido es: " + inputString);

        System.out.println("introduce un caracter: ");
        char inputCharacter = teclado.lerChar();

        System.out.println("El caracter que se ha introducido es: " + inputCharacter);

        System.out.println("introduce un enteiro: ");
        int inputInteger = Teclado.lerInt();

        System.out.println("O enteiro: " + inputInteger);

        System.out.println("introduce un numero enteiro largo: ");
        long inputLong = Teclado.lerLong();

        System.out.println("O numero que se introduciu e: " + inputLong);

        System.out.println("introduce true ou false");
        boolean inputBoolean = Teclado.lerBoolean();

        System.out.println("Introduciuse " + inputBoolean);

        System.out.println("introduce un decimal: ");
        float inputFloat = Teclado.leerFloat();

        System.out.println("o numero decimal que se introduciu e: " + inputFloat);

        System.out.println("introduce outro decimal: ");
        double inputdouble = Teclado.leerDouble();

        System.out.println(inputdouble);

        System.out.println("introduce un byte");





    }
}
