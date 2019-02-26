package model;

public class Drug {

    private int id;
    private String name;
    private String producer;
    private double packagePrice;

    public Drug(int id, String name, String producer, double packagePrice) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.packagePrice = packagePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public String toString() {
        return name + "\nвиробник: " + producer;
    }
}
