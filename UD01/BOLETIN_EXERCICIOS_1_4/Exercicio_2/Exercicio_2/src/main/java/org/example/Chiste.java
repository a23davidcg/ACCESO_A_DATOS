package org.example;

public class Chiste {
    private final boolean error;
    private final String category;
    private final String type;
    private final String setup;
    private final String delivery;
    private final boolean safe;
    private final int id;
    private final String lan;
    private BlackFlags blackFlags;


    public Chiste(boolean error, String category, String type, String setup, String delivery, boolean safe, int id, String lan) {
        this.error = error;
        this.category = category;
        this.type = type;
        this.setup = setup;
        this.delivery = delivery;
        this.safe = safe;
        this.id = id;
        this.lan = lan;
    }

    @Override
    public String toString() {
        return "Chiste{" +
                "error=" + error +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", delivery='" + delivery + '\'' +
                ", safe=" + safe +
                ", id=" + id +
                ", lan='" + lan + '\'' +
                '}';
    }
}
