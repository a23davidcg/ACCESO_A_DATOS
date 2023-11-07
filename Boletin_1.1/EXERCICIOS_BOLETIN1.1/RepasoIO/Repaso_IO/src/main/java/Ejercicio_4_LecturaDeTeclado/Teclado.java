package Ejercicio_4_LecturaDeTeclado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

    private BufferedReader bufferedReader() {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        return bufferedReader;
    }

    public String lerString() {
        try (BufferedReader Lector = this.bufferedReader()) {
            return Lector.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public char lerChar() {
        try {
            return Lector.readLine().charAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    public static int lerInt() {
        try {
            return Integer.parseInt(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static long lerLong() {

        try {
            return Long.parseLong(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean lerBoolean() {

        try {
            return Boolean.parseBoolean(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static float leerFloat() {

        try {
            return Float.parseFloat(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double leerDouble() {

        try {
            return Double.parseDouble(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte lerByte() {

        try {
            return Byte.parseByte(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static short lerShort() {

        try {
            return Short.parseShort(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
