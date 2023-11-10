import java.io.*;

public class Ejercicio_1D_Boletin_01_01 {
    public static void main(String[] args) throws IOException {
        File ficheiro = new File("D:\\MaquinasVirtuais\\AD\\Ficheiro.txt");

        try (BufferedReader in = new BufferedReader(new FileReader(ficheiro));
             PrintWriter out = new PrintWriter(
                     new FileWriter("D:\\MaquinasVirtuais\\AD\\Ficheirocopia.txt"))) {

            String b;
            out.println("Hi");
            while ((b = in.readLine()) != null) {
                out.println(b);
            }
        }


    }
}
