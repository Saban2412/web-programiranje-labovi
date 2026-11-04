package com.example.web_programiranje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double price;
    private int ramGb;
    private int storageGb;

    @OneToMany(mappedBy = "laptop")
    @JsonIgnore
    private List<Accessory> accessories = new ArrayList<>();

    public Laptop(String brand, String model, double price, int ramGb, int storageGb) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getBrand() { return brand; }
    public void setBrand(String brand){this.brand = brand;}
    public String getModel() { return model; }
    public void setModel(String model){this.model = model;}
    public double getPrice() { return price; }
    public void setPrice(double Price){this.price = price;}
    public int getRamGb() { return ramGb; }
    public void setRamGb(int ramGb){this.ramGb = ramGb;}
    public int getStorageGb() { return storageGb; }
    public void setStorageGb(int storageGb){this.storageGb = storageGb;}
    public List<Accessory> getAccessories() { return accessories; }
    public void setAccessories(List<Accessory> accessories){this.accessories = accessories;}
}