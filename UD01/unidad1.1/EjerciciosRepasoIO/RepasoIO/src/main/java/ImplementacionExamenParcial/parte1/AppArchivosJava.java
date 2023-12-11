package ImplementacionExamenParcial.parte1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Se desea crear un programa, AppArchivosJava, que recoge una ruta a un directorio en el que hay varios proyectos Java,
 * uno por directorio, y crea un archivo por cada directorio con el nombre del directorio y la extensión .java,
 * proyecto.java, siendo “proyecto” el nombre del directorio.
 * Dicho archivo debe contener el código de todos los archivos .java que hay dentro del directorio y
 * subdirectorios de cada proyecto-
 * Debe comprobar la existencia del directorio y que es un directorio.
 * Emplea la clase Files de la librería java.nio.file.
 */
public class AppArchivosJava {

    public static final String EXTENSION = ".java";


    /**
     * Método que recoge el Path de un directorio y devuelve el listado de todos los subdirectorios que contiene,
     * empleando el método Files.list.
     *
     * @param pathDirectorio Directorio en el que listar los directorios.
     *                       Si no es un directorio, lanza una excepción de tipo IllegalArgumentException.
     * @return lista de directorios.
     * @see IllegalArgumentException
     * @see Files#isDirectory(Path, LinkOption...)
     * @see Files#list(Path)
     */
    public static List<Path> listDirectories(Path pathDirectorio) {

        try {
            if (!Files.isDirectory(pathDirectorio)) {
                throw new IllegalArgumentException("La ruta no es correcta ");
            }
            return Files.list(pathDirectorio)
                    .filter(Files::isDirectory)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//        try {
//            if (!Files.isDirectory(pathDirectorio)) {
//                throw new IllegalArgumentException("La ruta no corresponde");
//            }
//
//            return Files.list(pathDirectorio)
//                    .filter(Files::isDirectory)
//                    .collect(Collectors.toList());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    //}


    /**
     * Método que devuelve una lista de archivos con la extensión indicada a partir de un directorio.
     * La ruta debe ser un directorio. Si no lo es, lanza una excepción de tipo IllegalArgumentException.
     * Emplea el método Files.walk para recorrer el directorio y por cada archivo comprueba si es un archivo regular
     * y si tiene la extensión indicada.
     * A ser posible, utiliza expresiones lambda y el método Stream.toList() para recoger el resultado del Stream.
     *
     * @param pathDirectorio Directiorio a partir del cual se busca.
     * @param fileExtension  extensión de los archivos a buscar.
     * @return lista de archivos con la extensión indicada.
     * @see IllegalArgumentException
     * @see Files#isDirectory(Path, LinkOption...)
     * @see Files#walk(Path, FileVisitOption...)
     * @see Files#isRegularFile(Path, LinkOption...)
     * @see Stream#toList()
     */

    public static List<Path> findByFileExtension(Path pathDirectorio, String fileExtension) {

        try {
            if (!Files.isDirectory(pathDirectorio)) {
                throw new IllegalArgumentException("ERROR");
            }

            try (var walk = Files.walk(pathDirectorio, FileVisitOption.FOLLOW_LINKS)) {
               return walk.filter(path -> Files.isRegularFile(pathDirectorio) && path.toString().endsWith(fileExtension))
                        .collect(Collectors.toList());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//        try {
//            if (!Files.isDirectory(pathDirectorio)) {
//                throw new IllegalArgumentException();
//            }
//
//            try (var walk = Files.walk(pathDirectorio, FileVisitOption.FOLLOW_LINKS)
//            ) {
//                return walk.filter(path -> Files.isRegularFile(path) && path.toString().endsWith(fileExtension))
//                        .collect(Collectors.toList());
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        try {
//            if (!Files.isDirectory(pathDirectorio)) {
//                throw new IllegalArgumentException();
//            }
//            return Files.walk(pathDirectorio, FileVisitOption.FOLLOW_LINKS)
//                    .filter(path -> Files.isRegularFile(path) && path.toString().endsWith(fileExtension))
//                    .collect(Collectors.toList());
//
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }



    /**
     * Método que recoge una ruta a un directorio, una lista de archivos, el nombre del directorio destino y
     * crea un archivo único con el contenido de los archivos de la lista en el directorio destino.
     *
     * @param pathDirectorio Directorio en el que crear el archivo.
     *                       Si no es un directorio, lanza una excepción de tipo IllegalArgumentExceptions
     * @see IllegalArgumentException
     * @see Files#isDirectory(Path, LinkOption...)
     */
    public static void createFile(Path pathDirectorio, List<Path> archivos, String nombreArchivo) {

        Path archivoDestino = pathDirectorio.resolve(nombreArchivo);

        try (BufferedWriter bw = new BufferedWriter((Writer) archivoDestino)) {
            for (Path archivo : archivos) {
                List<String> lines = Files.readAllLines(archivo);
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Non se puido crear o archivo para escribir");
        }
    }

//        Path archivoDestino = pathDirectorio.resolve(nombreArchivo);
//
//        try (BufferedWriter bw = new BufferedWriter((Writer) archivoDestino)) {
//            for (Path archivo : archivos) {
//                List<String> lines = Files.readAllLines(archivo);
//                for (String line : lines) {
//                    bw.write(line);
//                    bw.newLine();
//                }
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Path archivoDestino = pathDirectorio.resolve(nombreArchivo);
//        try (BufferedWriter bw = new BufferedWriter((Writer) archivoDestino)) {
//            for (Path archivo : archivos) {
//                List<String> lines = Files.readAllLines(archivo);
//                for (String line : lines) {
//                    bw.write(line);
//                    bw.newLine();
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    public static void main(String[] args) {

        Path directorio = Path.of("D:\\DAM 2\\AD\\ACCESO_A_DATOS\\UD01\\unidad1.1\\EjerciciosRepasoIO\\RepasoIO");

        String fileExtension = ".java";
        String nombreArchivo = "Pruebas.txt";

        List<Path> subdirectories = listDirectories(directorio);

        List<Path> archivos = List.of(Path.of("archivo1.txt"), Path.of("archivo2.txt"));

        for (Path subdirectory : subdirectories) {
            System.out.println("Subdiretorio encontrado " + subdirectory + System.lineSeparator());
        }

        List<Path> javaFiles = findByFileExtension(directorio, fileExtension);
        for (Path javaFile : javaFiles) {
            System.out.println("archivo .java: " + javaFile + System.lineSeparator());
        }

        createFile(directorio, archivos, nombreArchivo);
    }


}
