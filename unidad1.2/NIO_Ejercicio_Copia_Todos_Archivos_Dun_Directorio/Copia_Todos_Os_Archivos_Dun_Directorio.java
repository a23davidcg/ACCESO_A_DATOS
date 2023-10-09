import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Copia_Todos_Os_Archivos_Dun_Directorio {

    //Creamos o metodo para copiar todos os archivos .java dun directorio noutro

    public static void copyPath (Path origen , final Path destino){
        try {
            if (!Files.isDirectory(origen) && origen.getFileName().toString().endsWith(".java")) {
                Files.copy(origen, destino.resolve(origen.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            } else if (Files.isDirectory(origen) ){
                try (Stream<Path> s = Files.list(origen)) {
                    s.forEach(p -> copyPath(p, destino.resolve(p.getFileName())));
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        /*Realiza un programa que copie todos los archivos *.java (incluidos subdirectorios) en un directorio destinio.

Si el directorio destino no existe debe crearlo.
Recorre el directorio y si es un directorio invócalo recursivamente.
Filtra de modo que el nombre del archivo termine en .java*/



        String origen = "D:\\MaquinasVirtuais\\AD\\unidad1.2\\Exercicios\\exercicio02\\src\\main\\java\\org\\example";
        String destino = "D:\\MaquinasVirtuais\\AD\\unidad1.2\\Proba_Copia_.Java";

        copyPath (Paths.get(origen), Paths.get(destino));






        }

//        public static void coppyPath (Path origen, final Path destino) {
//        try {
//        if (Files.isDirectory(origen) && origen.getFileName().toString().endsWith(".java")){
//        Files.copy(origen, destino.resolve(origen.getFileName()));
//        StandardCopyOption.REPLACE_EXISTING;
//        } else if (Files.isDirectory(origen)) {
//            try (Stream<Path> s = Files.list(origen)) {
//                s.forEach(p -> coppyPath(p, destino));
//
//            }
//        }
//        }
//        }

    }
