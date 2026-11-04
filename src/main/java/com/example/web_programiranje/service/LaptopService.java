package com.example.web_programiranje.service;

import com.example.web_programiranje.model.Laptop;
import org.springframework.stereotype.Service;
import com.example.web_programiranje.repository.LaptopRepository;

import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    public Laptop findById(Long id){
        return (Laptop) laptopRepository.findById(id).orElse(null);
    }
}
