package local.exame.ad.ficheros.javanio2;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
            boolean directorio =  Files.isDirectory(pathDirectorio);
            if (directorio == true){
                Files.list(pathDirectorio).filter(Path::isAbsolute).toList();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

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
        try (Stream<Path> paths = Files.walk(Path.of("C:\\Users\\dam2ad\\Desktop\\AD20231116Ficheros"))){
            paths.filter(path -> !Files.isDirectory(path))
                    .filter(path -> path.endsWith(".java"))
                    //TODO:REVISAR AQUI
                    .forEach(path -> {
                        String contenido = null;
                        try {
                            contenido = Files.readString(pathDirectorio);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(contenido);
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return null;

    }

    // No se pide, pero se puede hacer: ;-) Descomprimir un archivo ZIP
//    public void uncompressZIP(Path file, boolean deleteZip){
//            try (var zip = new ZipInputStream(Files.newInputStream(file))) {
//            ZipEntry entrada;
//            while ((entrada = zip.getNextEntry()) != null) {
//                Path path = Paths.get(entrada.getName());
//                if (entrada.isDirectory()) {
//                    Files.createDirectories(path);
//                } else {
//                    Files.copy(zip, path);
//                }
//            }
//            if (deleteZip) {
//                Files.delete(file);
//            }
//        } catch (IOException e) {
//            System.err.println("Error al descomprimir el archivo: " + e.getMessage());
//        }
//    }

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

    }

    public static void main(String[] args) {



        AppArchivosJava.listDirectories(Path.of("C:\\Users\\dam2ad\\Desktop\\AD20231116Ficheros"));


    }


}
