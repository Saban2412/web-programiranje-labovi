package com.example.web_programiranje.service;

import com.example.web_programiranje.model.Accessory;
import org.springframework.stereotype.Service;
import com.example.web_programiranje.repository.AccessoryRepository;

import java.util.List;

@Service
public class AccessoryService {
    private final AccessoryRepository accessoryRepository;

    public AccessoryService(AccessoryRepository accessoryRepository){
        this.accessoryRepository=accessoryRepository;
    }
    public List<Accessory> findAll(){
        return accessoryRepository.findAll();
    }
}
