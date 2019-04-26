package com.trung.assgiaodien;

public class Model {
    int id;
    String mid;
    String name;
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Model(int id, String mid, String name, double price) {

        this.id = id;
        this.mid = mid;
        this.name = name;
        this.price = price;
    }
}
