package Ejercicio_4_LecturaDeTeclado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

    //Para non ter que facer o buffered en ccada un dos metodos

    private BufferedReader bufferedReader() {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        return bufferedReader;
    }

    //METODOS

    public String lerString() {
        try (BufferedReader Lector = this.bufferedReader()) {
            return Lector.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public char lerChar() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Lector.readLine().charAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*try {
            return Lector.readLine().charAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }*/

    }

    public int lerInt() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Integer.parseInt(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//            return Integer.parseInt(Lector.readLine());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    public long lerLong() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Long.parseLong(Lector.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean lerBoolean() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Boolean.parseBoolean(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public float leerFloat() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Float.parseFloat(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double leerDouble() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Double.parseDouble(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte lerByte() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Byte.parseByte(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public short lerShort() {

        try (BufferedReader Lector = this.bufferedReader()) {
            return Short.parseShort(Lector.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
