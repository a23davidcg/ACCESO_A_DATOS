import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class AppFluxos {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //Leer url y qeu cree un archivo en e
        //abrir fluxo a ese sitio url
        File fOrixe = new File(new URI("https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/PrintWriter.html"));

        //Creamos fluxo a ese archivo
        //Leemos archivo
        BufferedInputStream fr = new BufferedInputStream(new FileInputStream(fOrixe));
        //Gardamolo
        BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream("D:\\"));
        //leemos byte a byte
        int b;
        //leemos do buffer de entrada
        while(( b = fr.read()) !=-1);{
            fw.write(b);
        }
        fw.close();
        fr.close();

        //fluxo de texto
        //InputStreamReader




    }
}
