package com.example.demo;


public class User {
    private String make;
    private String model;
    private int price;
    private boolean electric;

    public User(String make, String model, int price, boolean electric) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.electric = electric;
    }

    // Getter & Setter
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public boolean isElectric() { return electric; }
    public void setElectric(boolean electric) { this.electric = electric; }
}