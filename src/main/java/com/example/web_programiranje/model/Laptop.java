package com.example.web_programiranje.model;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private int id;
    private String brand;
    private String model;
    private double price;
    private int ramGb;
    private int storageGb;
    private List<Accessory> accessories;

    public Laptop(int id, String brand, String model, double price, int ramGb, int storageGb) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
        this.accessories = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public int getRamGb() { return ramGb; }
    public int getStorageGb() { return storageGb; }
    public List<Accessory> getAccessories() { return accessories; }
}