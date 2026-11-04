package com.example.web_programiranje.data;

import com.example.web_programiranje.model.Accessory;
import com.example.web_programiranje.model.Laptop;
import com.example.web_programiranje.model.Narudzba;
import com.example.web_programiranje.repository.AccessoryRepository;
import com.example.web_programiranje.repository.LaptopRepository;
import com.example.web_programiranje.repository.NarudzbaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final LaptopRepository laptopRepository;
    private final AccessoryRepository accessoryRepository;
    private final NarudzbaRepository narudzbaRepository;

    public DataLoader(LaptopRepository laptopRepository, AccessoryRepository accessoryRepository, NarudzbaRepository narudzbaRepository){
        this.laptopRepository = laptopRepository;
        this.accessoryRepository = accessoryRepository;
        this.narudzbaRepository = narudzbaRepository;
    }

    @Override
    public void run (String... args){
        if (laptopRepository.count() > 0){
            return;
        }

        Laptop l1 = laptopRepository.save(new Laptop("Lenovo", "ThinkPad E14", 1299.0, 16, 512));
        Laptop l2 = laptopRepository.save(new Laptop("HP", "Pavilion 15", 999.0, 8, 512));
        Laptop l3 = laptopRepository.save(new Laptop("Asos", "ROG Strix G16", 2199.0, 32, 1024));
        Laptop l4 = laptopRepository.save(new Laptop("Apple", "MacBook Air M2", 1799.0, 16, 256));

        accessoryRepository.save(new Accessory(1, "Logitech M185 mis", "Mis", 25.0, true, l1));
        accessoryRepository.save(new Accessory(1, "Torba 14-inch", "Torba", 55.0, true, l1));
        accessoryRepository.save(new Accessory(1, "USB-C dock", "Dock stanica", 89.0, true, l1));
        accessoryRepository.save(new Accessory(1, "MagSafe punjac", "Punjac", 49.0, true, l4));

        Narudzba n1 = new Narudzba();
        n1.setImeKupca("Amir Hadzic");
        n1.setEmail("amir.hadzic@gmail.com");
        n1.setKolicina(1);
        n1.setDatum(LocalDate.now());
        n1.setStatus("Nova");
        n1.setLaptop(l1);
        narudzbaRepository.save(n1);
    }
}
