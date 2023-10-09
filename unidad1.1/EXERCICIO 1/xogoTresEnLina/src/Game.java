import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    public static void main (String args []) throws FileNotFoundException {
        Random xerador = new Random(0); //No caso que sempre queiramos mostrar a mesma secuencia de numeros para cada usuario como e o caso do dni, que semore se mostre o mesmo para o mesmo usuario.
        int i;
        for (int i ; j< 10; j++){
            System.out.println(xerador.nextInt(2));
        }

        System.out.println("xerador.nextInt() = " + xerador.nextInt());



    }
}
