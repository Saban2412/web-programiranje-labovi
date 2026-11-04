package com.example.web_programiranje.controller;

import com.example.web_programiranje.model.Narudzba;
import com.example.web_programiranje.service.NarudzbaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/narudzbe")
public class NarudzbaRestController {

    private final NarudzbaService narudzbaService;

    public NarudzbaRestController(NarudzbaService narudzbaService) {
        this.narudzbaService = narudzbaService;
    }

    // GET /api/narudzbe  -> sve narudzbe kao JSON
    @GetMapping
    public List<Narudzba> sve() {
        return narudzbaService.findAll();
    }

    // GET /api/narudzbe/1  -> jedna narudzba, ili 404 ako ne postoji
    @GetMapping("/{id}")
    public ResponseEntity<Narudzba> jedna(@PathVariable Long id) {
        Narudzba n = narudzbaService.findById(id);
        if (n == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(n);
    }
}