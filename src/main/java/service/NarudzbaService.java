package service;

import com.example.web_programiranje.model.Narudzba;
import org.springframework.stereotype.Service;
import repository.NarudzbaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NarudzbaService {
    private final NarudzbaRepository narudzbaRepository;

    public NarudzbaService(NarudzbaRepository narudzbaRepository){
        this.narudzbaRepository=narudzbaRepository;
    }
    public List<Narudzba> findAll(){
        return narudzbaRepository.findAll();
    }
    public Narudzba findById(Long id){
        return (Narudzba) narudzbaRepository.findById(id).orElse(null);
    }
    public Narudzba save(Narudzba narudzba){
        return (Narudzba) narudzbaRepository.save(narudzba);
    }
}
