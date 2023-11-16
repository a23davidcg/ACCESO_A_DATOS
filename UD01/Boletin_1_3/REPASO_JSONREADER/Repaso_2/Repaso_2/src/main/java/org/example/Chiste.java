package org.example;

public class Chiste {
    private boolean error;
    private String category;
    private String type;
    private String setup;
    private String delivery;
    private boolean safe;
    private int id;
    private String lan;
    private BlackFlags blackFlags;

    public Chiste(boolean error, String category, String type, String setup, String delivery, boolean safe, int id, String lan, BlackFlags blackFlags) {
        this.error = error;
        this.category = category;
        this.type = type;
        this.setup = setup;
        this.delivery = delivery;
        this.safe = safe;
        this.id = id;
        this.lan = lan;
        this.blackFlags = blackFlags;
    }

    public Chiste() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public BlackFlags getBlackFlags() {
        return blackFlags;
    }

    public void setBlackFlags(BlackFlags blackFlags) {
        this.blackFlags = blackFlags;
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
                ", blackFlags=" + blackFlags +
                '}';
    }
}
