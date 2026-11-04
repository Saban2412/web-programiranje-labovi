package service;

import com.example.web_programiranje.model.Laptop;
import org.springframework.stereotype.Service;
import repository.LaptopRepository;

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
    public ScopedValue<Object> findById(Long id){
        return (ScopedValue<Object>) laptopRepository.findById(id).orElse(null);
    }
}
