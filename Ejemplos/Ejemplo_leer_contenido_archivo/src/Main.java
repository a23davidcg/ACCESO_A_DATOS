import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("d:\\imput.txt"))){
            String line;
            while ((line = br.readLine())!= null){
                System.out.println(line);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Contido.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Contido.class.getName()).log(Level.SEVERE, null, ex);
        }

        try{
            List<String> linhas = Files.readAllLines(Paths.get("d:\\imput.txt"));
            for(String linha : linhas){
                System.out.println(linha);
            }
        }catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }







    }
}