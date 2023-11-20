package org.example;

import java.io.File;

public class FileSingleton  {

    //Creo o constructor como privado

    public static FileSingleton instance = new FileSingleton();

    private FileSingleton(){

    }

    public static FileSingleton getInstance(){
        return instance;
    }
}
