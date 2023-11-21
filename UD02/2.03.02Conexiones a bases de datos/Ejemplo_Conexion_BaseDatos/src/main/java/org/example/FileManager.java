package com.pepinho.ad.jdbc;

public class FileManager {

    private static FileManager instance = new FileManager();

    private FileManager(){

    }

    public static FileManager getInstance(){
        return instance;
    }
}
