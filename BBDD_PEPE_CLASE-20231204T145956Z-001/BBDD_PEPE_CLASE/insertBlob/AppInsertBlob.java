package com.pepinho.programacion.boletin02.docencia;

/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author pepecalo
 */
public class AppInsertBlob {

    public static final String URL_DB = "jdbc:sqlite:E:\\98 - Bases de datos"
            + "\\blobs\\blobexample.sqlite3";
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {
//        try {
//            // Inicio
//            Class.forName(JDBC_DRIVER);
//
//            Connection con = DriverManager.getConnection(URL_DB);
//
////            PreparedStatement ps = con.prepareStatement("SELECT nome, imaxe FROM"
////                    + " Foto where idImaxe=1");
////
////            ResultSet rs = ps.executeQuery();
////
////            String nome;
////            InputStream is = null;
////            if(rs.next()){
////                nome = rs.getString(1);
////                is = rs.getBinaryStream(2);
////            }
////
////            // REpaso fluxos
////            BufferedOutputStream os = new BufferedOutputStream(
////                    new FileOutputStream("e:\\newPutin.jpg"));
////            int b;
////            while( (b=is.read())!=-1){
////                os.write(b);
////            }
//            //catch (IOException ex) {
//
//        }


    }


    public static boolean insertBlob(Connection con, String filename) {

        try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
                + "(nome, imaxe) VALUES (?,?)")) {

            File f = new File(filename);
            BufferedInputStream fis = new BufferedInputStream(
                    new FileInputStream(f));
            ps.setString(1, "Check box 2");
            ps.setBinaryStream(2, fis, (int) f.length());
            int i = ps.executeUpdate();
            return i != 0;

        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }

        return false;
    }

    /**
     * Método que recoge la conexión a la base de datos y el nombre del fichero
     * y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
     * Introduce los datos en la base de datos con setBytes.
     */
    public static boolean insertBlobNIO2(Connection con, String filename) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
                + "(nome, imaxe) VALUES (?,?)")) {

            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            ps.setString(1, "Check box 3");
            ps.setBytes(2, fis.readAllBytes());
            int i = ps.executeUpdate();
            return i != 0;

        } catch (SQLException | IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
        return false;
    }

    /**
     * Método que recoge la conexión a la base de datos y el nombre del fichero
     * Y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
     * Emplea setBinaryStream para introducir los datos en la base de datos.
     */

public static boolean insertBlobNIO3(Connection con, String filename) {
    try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
            + "(nome, imaxe) VALUES (?,?)")) {

        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        ps.setString(1, "Check box 3");
        ps.setBinaryStream(2, fis);
        int i = ps.executeUpdate();
        return i != 0;

    } catch (SQLException | IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
    }
    return false;
}

/**
 * Método que recoge la conexión a la base de datos y el nombre del fichero
 * Y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
 * Emplea el método setBlob para introducir los datos en la base de datos.
 */
public static boolean insertBlobNIO4(Connection con, String filename) {
    try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
            + "(nome, imaxe) VALUES (?,?)")) {

        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        ps.setString(1, "Check box 3");
        ps.setBlob(2, fis);
        int i = ps.executeUpdate();
        return i != 0;

    } catch (SQLException | IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
    }
    return false;
}

    /**
     * Método que recoge la conexión a la base de datos y el nombre del fichero
     * Y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
     * Emplea el método setBlob para introducir los datos en la base de datos.
     */
    public static boolean insertBlobNIO5(Connection con, String filename) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
                + "(nome, imaxe) VALUES (?,?)")) {

            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            ps.setString(1, "Check box 3");
            ps.setBlob(2, fis, f.length());
            int i = ps.executeUpdate();
            return i != 0;

        } catch (SQLException | IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
        return false;
}

/**
 * Método que recoge la conexión a la base de datos y el nombre del fichero
 * Y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
 * Emplea el método setBlob para introducir los datos en la base de datos.
 * Crea un objeto de tipo Blob para introducir los datos en la base de datos.
 */
public static boolean insertBlobNIO6(Connection con, String filename) {
    try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
            + "(nome, imaxe) VALUES (?,?)")) {

        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        Blob blob = con.createBlob();
        blob.setBytes(1, fis.readAllBytes());
        ps.setString(1, "Check box 3");
        ps.setBlob(2, blob);
        int i = ps.executeUpdate();
        return i != 0;

    } catch (SQLException | IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
    }
    return false;
}

    /**
     * Método que recoge la conexión a la base de datos y el nombre del fichero
     * Y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
     * Emplea el método setBlob para introducir los datos en la base de datos.
     * Crea un objeto de tipo Blob para introducir los datos en la base de datos.
     */
    public static boolean insertBlobNIO7(Connection con, String filename) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
                + "(nome, imaxe) VALUES (?,?)"); FileInputStream fis = new FileInputStream(filename); ) {

            // Creamos un Blob
            Blob blob = con.createBlob();
            ps.setString(1, "Check box 3");
            ps.setBlob(2, blob);
            int i = ps.executeUpdate();
            return i != 0;

        } catch (SQLException | IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
        return false;
    }

    /**
     * Método que recoge la conexión a la base de datos y el nombre del fichero
     * Y, por medio de Java Files.newInputStream, inserta el blob en la base de datos.
     * Emplea el método setBlob para introducir los datos en la base de datos.
     * Crea un objeto de tipo Blob para introducir los datos en la base de datos.
     */
    public static boolean insertBlobNIO8(Connection con, String filename) {
try (PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
                + "(nome, imaxe) VALUES (?,?)")) {

            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            Blob blob = con.createBlob();
            ps.setString(1, "Check box 3");
            ps.setBlob(2, blob);
            int i = ps.executeUpdate();
            return i != 0;

        } catch (SQLException | IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
        return false;
    }


    /** Inserta un blob en la base de datos por medio de java NIO la lectura y la escritura del flujo.
     * @param con conexión a la base de datos
     * @param filename nombre del fichero a insertar
     * @return true si se insertó correctamente, false en caso contrario
     */
    public static boolean insertBlobNIO(Connection con, String filename) {
        try(PreparedStatement ps = con.prepareStatement("INSERT INTO Foto"
                + "(nome, imaxe) VALUES (?,?)")){

            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            FileChannel fc = fis.getChannel();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableByteChannel wbc = Channels.newChannel(baos);
            ByteBuffer bb = ByteBuffer.allocateDirect(16 * 1024);
            while (fc.read(bb) != -1) {
                bb.flip();
                wbc.write(bb);
                bb.clear();
            }
            fis.close();
            ps.setString(1, "Check box 3");
            ps.setBytes(2, baos.toByteArray());
            int i = ps.executeUpdate();
            return i != 0;

        } catch (SQLException | IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
        return false;
    }
}
