package com.example.web_programiranje.model;

import jakarta.persistence.*;

@Entity
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private double price;
    private boolean inStock;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    public Accessory(){}

    public Accessory(int id, String name, String type, double price, boolean inStock, Laptop laptop) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.inStock = inStock;
        this.laptop = laptop;
    }

    public Long getId() { return id; }
    public void setId(Long id){this.id=id;}
    public String getName() { return name; }
    public void setName(String name){this.name=name;}
    public String getType() { return type; }
    public void setType(String type) {this.type=type;}
    public double getPrice() { return price; }
    public void setPrice(double Price){this.price = price;}
    public boolean isInStock() { return inStock; }
    public void setInStocks(boolean inStock){this.inStock=inStock;}
    public Laptop getLaptop() { return laptop; }
    public void setLaptop(Laptop laptop){this.laptop=laptop;}
}

