package com.example.web_programiranje.data;

import com.example.web_programiranje.model.Accessory;
import com.example.web_programiranje.model.Laptop;

import java.util.ArrayList;
import java.util.List;

public class DemoData {

    public static List<Laptop> laptops = new ArrayList<>();
    public static List<Accessory> accessories = new ArrayList<>();

    static {
        Laptop l1 = new Laptop(1, "Lenovo", "ThinkPad E14", 1299.0, 16, 512);
        Laptop l2 = new Laptop(2, "HP", "Pavilion 15", 999.0, 8, 512);
        Laptop l3 = new Laptop(3, "Asus", "ROG Strix G16", 2199.0, 32, 1024);
        Laptop l4 = new Laptop(4, "Apple", "MacBook Air M2", 1799.0, 16, 256);

        laptops.add(l1);
        laptops.add(l2);
        laptops.add(l3);
        laptops.add(l4);

        addAccessory(new Accessory(1, "Logitech M185 mis", "Mis", 25.0, true, l1));
        addAccessory(new Accessory(2, "Torba 14 inch", "Torba", 39.0, true, l1));
        addAccessory(new Accessory(3, "USB-C dock", "Dock stanica", 89.0, false, l1));
        addAccessory(new Accessory(4, "Hladnjak za laptop", "Hladjenje", 35.0, true, l2));
        addAccessory(new Accessory(5, "Bezicna tastatura", "Tastatura", 45.0, true, l2));
        addAccessory(new Accessory(6, "Gaming mis G502", "Mis", 79.0, true, l3));
        addAccessory(new Accessory(7, "Gaming slusalice", "Slusalice", 119.0, true, l3));
        addAccessory(new Accessory(8, "Ruksak 17 inch", "Torba", 59.0, true, l3));
        addAccessory(new Accessory(9, "MagSafe punjac", "Punjac", 49.0, true, l4));
        addAccessory(new Accessory(10, "Zastitna futrola", "Torba", 29.0, true, l4));
    }

    private static void addAccessory(Accessory a) {
        accessories.add(a);
        a.getLaptop().getAccessories().add(a);
    }
}