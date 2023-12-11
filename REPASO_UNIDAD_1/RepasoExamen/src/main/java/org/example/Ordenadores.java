package org.example;

import java.io.Serializable;

public class Ordenadores implements Serializable {
    private String id;

    private Images images;
    private String path;
    private int width;
    private int height;
    private String pathMedium;
    private int widthMedium;
    private int heightMedium;
    private String pathLarge;
    private int withLarge;
    private int heightLarge;

    public Ordenadores() {
    }

    public Ordenadores(String id, String path, int width, int height, String pathMedium, int widthMedium, int heightMedium, String pathLarge, int withLarge, int heightLarge) {
        this.id = id;
        this.path = path;
        this.width = width;
        this.height = height;
        this.pathMedium = pathMedium;
        this.widthMedium = widthMedium;
        this.heightMedium = heightMedium;
        this.pathLarge = pathLarge;
        this.withLarge = withLarge;
        this.heightLarge = heightLarge;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPathMedium() {
        return pathMedium;
    }

    public void setPathMedium(String pathMedium) {
        this.pathMedium = pathMedium;
    }

    public int getWidthMedium() {
        return widthMedium;
    }

    public void setWidthMedium(int widthMedium) {
        this.widthMedium = widthMedium;
    }

    public int getHeightMedium() {
        return heightMedium;
    }

    public void setHeightMedium(int heightMedium) {
        this.heightMedium = heightMedium;
    }

    public String getPathLarge() {
        return pathLarge;
    }

    public void setPathLarge(String pathLarge) {
        this.pathLarge = pathLarge;
    }

    public int getWithLarge() {
        return withLarge;
    }

    public void setWithLarge(int withLarge) {
        this.withLarge = withLarge;
    }

    public int getHeightLarge() {
        return heightLarge;
    }

    public void setHeightLarge(int heightLarge) {
        this.heightLarge = heightLarge;
    }

    @Override
    public String toString() {
        return "Ordenadores{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", pathMedium='" + pathMedium + '\'' +
                ", widthMedium='" + widthMedium + '\'' +
                ", heightMedium='" + heightMedium + '\'' +
                ", pathLarge='" + pathLarge + '\'' +
                ", withLarge=" + withLarge +
                ", heightLarge=" + heightLarge +
                '}';
    }
}



