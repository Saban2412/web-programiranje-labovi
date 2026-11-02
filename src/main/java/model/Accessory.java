package model;

public class Accessory {
    private int id;
    private String name;
    private String type;
    private double price;
    private boolean inStock;
    private Laptop laptop; // oprema pripada jednom laptopu

    public Accessory(int id, String name, String type, double price, boolean inStock, Laptop laptop) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.inStock = inStock;
        this.laptop = laptop;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isInStock() { return inStock; }
    public Laptop getLaptop() { return laptop; }
}

