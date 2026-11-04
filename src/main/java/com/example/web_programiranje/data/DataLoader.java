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

    public DataLoader(LaptopRepository laptopRepository,
                      AccessoryRepository accessoryRepository,
                      NarudzbaRepository narudzbaRepository) {
        this.laptopRepository = laptopRepository;
        this.accessoryRepository = accessoryRepository;
        this.narudzbaRepository = narudzbaRepository;
    }

    @Override
    public void run(String... args) {
        if (laptopRepository.count() > 0) {
            return;
        }

        Laptop l1 = (Laptop) laptopRepository.save(new Laptop("Lenovo", "ThinkPad E14", 1299.0, 16, 512));
        Laptop l2 = (Laptop) laptopRepository.save(new Laptop("HP", "Pavilion 15", 999.0, 8, 512));
        Laptop l3 = (Laptop) laptopRepository.save(new Laptop("Asus", "ROG Strix G16", 2199.0, 32, 1024));
        Laptop l4 = (Laptop) laptopRepository.save(new Laptop("Apple", "MacBook Air M2", 1799.0, 16, 256));

        accessoryRepository.save(new Accessory(1,"Logitech M185 mis", "Mis", 25.0, true, l1));
        accessoryRepository.save(new Accessory(2,"Torba 14 inch", "Torba", 39.0, true, l1));
        accessoryRepository.save(new Accessory(3,"USB-C dock", "Dock stanica", 89.0, false, l1));
        accessoryRepository.save(new Accessory(4,"Hladnjak za laptop", "Hladjenje", 35.0, true, l2));
        accessoryRepository.save(new Accessory(5,"Bezicna tastatura", "Tastatura", 45.0, true, l2));
        accessoryRepository.save(new Accessory(6,"Gaming mis G502", "Mis", 79.0, true, l3));
        accessoryRepository.save(new Accessory(7,"Gaming slusalice", "Slusalice", 119.0, true, l3));
        accessoryRepository.save(new Accessory(8,"Ruksak 17 inch", "Torba", 59.0, true, l3));
        accessoryRepository.save(new Accessory(9,"MagSafe punjac", "Punjac", 49.0, true, l4));
        accessoryRepository.save(new Accessory(10,"Zastitna futrola", "Torba", 29.0, true, l4));

        Narudzba n1 = new Narudzba();
        n1.setImeKupca("Amar Hadzic");
        n1.setEmail("amar@example.com");
        n1.setKolicina(1);
        n1.setDatum(LocalDate.now());
        n1.setStatus("Nova");
        n1.setLaptop(l1);
        narudzbaRepository.save(n1);

        Narudzba n2 = new Narudzba();
        n2.setImeKupca("Lejla Kovac");
        n2.setEmail("lejla@example.com");
        n2.setKolicina(2);
        n2.setDatum(LocalDate.now());
        n2.setStatus("U obradi");
        n2.setLaptop(l3);
        narudzbaRepository.save(n2);
    }
}