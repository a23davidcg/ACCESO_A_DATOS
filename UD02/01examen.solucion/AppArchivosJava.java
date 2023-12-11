package com.pepinho.ad.ud01.javanio2;

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
        if (!Files.isDirectory(pathDirectorio)) {
            throw new IllegalArgumentException("La ruta debe ser un directorio!");
        }

        List<Path> listaDeDirectorios = null;
        try (Stream<Path> stream = Files.list(pathDirectorio)) {
            listaDeDirectorios = stream.filter(Files::isDirectory)   // es un directorio
                    .toList();
            // .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return listaDeDirectorios;
    }

    /**
     * Método que devuelve una lista de archivos con la extensión indicada a partir de un directorio.
     * La ruta debe ser un directorio. Si no lo es, lanza una excepción de tipo IllegalArgumentException.
     * Emplea el método Files.walk para recorrer el directorio y por cada archivo comprueba si es un archivo regular
     * y si tiene la extensión indicada.
     * A ser posible, utiliza expresiones lambda y el método Stream.toList() para recoger el resultado del Stream.
     *
     * @param pathDirectorio Directorio a partir del cual se busca.
     * @param fileExtension  extensión de los archivos a buscar.
     * @return lista de archivos con la extensión indicada.
     * @see IllegalArgumentException
     * @see Files#isDirectory(Path, LinkOption...)
     * @see Files#walk(Path, FileVisitOption...)
     * @see Files#isRegularFile(Path, LinkOption...)
     * @see Stream#toList()
     */

    public static List<Path> findByFileExtension(Path pathDirectorio, String fileExtension) {

        if (!Files.isDirectory(pathDirectorio)) {
            throw new IllegalArgumentException("La ruta debe ser un directorio!");
        }

        List<Path> result = null;
        try (Stream<Path> walk = Files.walk(pathDirectorio)) {
            result = walk.filter(Files::isRegularFile)   // es un archivo
                    .filter(p -> p.getFileName().toString().endsWith(fileExtension)).toList();
            // .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

    public static void unCompressDirectory(Path directory){
        try (Stream<Path> walk = Files.walk(directory)) {
            walk.filter(Files::isRegularFile)   // es un archivo
                    .filter(p -> p.getFileName().toString().toLowerCase().endsWith(".zip")
                            || p.getFileName().toString().toLowerCase().endsWith(".gz"))
                    .forEach(p -> uncompressZIP(p, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void uncompressZIP(Path file, boolean deleteZip){
            try (var zip = new ZipInputStream(Files.newInputStream(file))) {
            ZipEntry entrada;
            while ((entrada = zip.getNextEntry()) != null) {
                System.out.println(entrada.getName());
                Path path = Paths.get(entrada.getName());
                if (entrada.isDirectory()) {
                    Files.createDirectories(path);
                } else {
                    Files.copy(zip, path);
                }
            }
            if (deleteZip) {
                Files.delete(file);
            }
        } catch (IOException e) {
            System.err.println("Error al descomprimir el archivo: " + e.getMessage());
        } }

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
        if (!Files.isDirectory(pathDirectorio)) {
            throw new IllegalArgumentException("La ruta debe ser un directorio!");
        }

        Path pathArchivo = Paths.get(pathDirectorio.toString(), nombreArchivo);
        try (var bwDestino = Files.newBufferedWriter(pathArchivo)) {
            for (Path archivo : archivos) {
                try (var brOrigen = Files.newBufferedReader(archivo)) {
                    String linea;
                    while ((linea = brOrigen.readLine()) != null) {
                        bwDestino.write(linea);
                        bwDestino.newLine();
                    }
                } catch (IOException e) {
                    System.err.println("Error al leer el archivo: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void createFile2(Path pathDirectorio, List<Path> archivos, String nombreArchivo) throws IOException {
        if (!Files.isDirectory(pathDirectorio)) {
            throw new IllegalArgumentException("La ruta debe ser un directorio!");
        }

        Path pathArchivo = Paths.get(pathDirectorio.toString(), nombreArchivo);
        for (Path archivo : archivos) {
            try (var bwDestino = Files.newBufferedWriter(pathArchivo);
                 var brOrigen = Files.newBufferedReader(archivo)) {
                String linea;
                while ((linea = brOrigen.readLine()) != null) {
                    bwDestino.write(linea);
                    bwDestino.newLine();
                }
            } catch (IOException e) {
                throw new IOException("Error al leer o escribir el archivo: " + e.getMessage(), e);
            }
        }
    }

    public static String DIRECTORY = "E:\\00 - Acceso a Datos\\Curso 2023-24 Acceso a datos\\examenes\\1eval\\estudantes";

    public static void main(String[] args) throws IOException {
        // el primer argumento es la ruta al directorio si no se indica se toma el directorio actual.
        // el segundo argumento es la ruta al archivo de salida si no se indica se toma el directorio actual.
        // si no se indica el primer argumento se toma el directorio actual.
        // si no se indica el segundo argumento se toma el directorio actual.

        Path directorio = Paths.get((args.length == 0) ? DIRECTORY : args[0]);

        if (!Files.exists(directorio) && !Files.isDirectory(directorio)) {
            System.err.println("El directorio no existe");
            System.exit(1);
        }

        unCompressDirectory(directorio);

        List<Path> directorios = listDirectories(directorio);

        for (Path dir : directorios) {
            System.out.println(dir.getFileName());
        }
//        // Con expresiones lambda:
//        directorios.forEach(dir -> {
//            List<Path> archivos = findByFileExtension(dir, EXTENSION);
//            createFile(dir, archivos, dir.getFileName().toString() + EXTENSION);
//        });

/* // Con bucle for:
//
//        for (Path dir : directorios) {
//            List<Path> archivos = findByFileExtension(dir, EXTENSION);
//            createFile(dir, archivos, dir.getFileName().toString() + EXTENSION);
//        }

 */




    }








}
