package com.example.web_programiranje.controller;

import com.example.web_programiranje.model.Narudzba;
import com.example.web_programiranje.service.LaptopService;
import com.example.web_programiranje.service.NarudzbaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/narudzbe")
public class NarudzbaController {

    private final NarudzbaService narudzbaService;
    private final LaptopService laptopService;

    private final List<String> statusi = List.of("Nova", "U obradi", "Poslana", "Otkazana");

    public NarudzbaController(NarudzbaService narudzbaService, LaptopService laptopService) {
        this.narudzbaService = narudzbaService;
        this.laptopService = laptopService;
    }

    // lista narudzbi: GET /narudzbe
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("narudzbe", narudzbaService.findAll());
        return "narudzbe";
    }

    // prikaz prazne forme: GET /narudzbe/nova
    @GetMapping("/nova")
    public String novaForma(Model model) {
        model.addAttribute("naslov", "Nova narudzba");
        model.addAttribute("akcija", "/narudzbe/nova");
        model.addAttribute("narudzba", new Narudzba());
        model.addAttribute("laptops", laptopService.findAll());
        model.addAttribute("statusi", statusi);
        return "narudzba-forma";
    }

    // spremanje nove narudzbe: POST /narudzbe/nova
    @PostMapping("/nova")
    public String spremi(@RequestParam String imeKupca,
                         @RequestParam String email,
                         @RequestParam int kolicina,
                         @RequestParam String status,
                         @RequestParam Long laptopId) {

        Narudzba n = new Narudzba();
        n.setImeKupca(imeKupca);
        n.setEmail(email);
        n.setKolicina(kolicina);
        n.setStatus(status);
        n.setDatum(LocalDate.now());
        n.setLaptop(laptopService.findById(laptopId));

        narudzbaService.save(n);
        return "redirect:/narudzbe";
    }

    // prikaz forme popunjene postojecim podacima: GET /narudzbe/5/edit
    @GetMapping("/{id}/edit")
    public String editForma(@PathVariable Long id, Model model) {
        Narudzba n = narudzbaService.findById(id);
        if (n == null) {
            return "redirect:/narudzbe";
        }
        model.addAttribute("naslov", "Izmjena narudzbe #" + id);
        model.addAttribute("akcija", "/narudzbe/" + id + "/edit");
        model.addAttribute("narudzba", n);
        model.addAttribute("laptops", laptopService.findAll());
        model.addAttribute("statusi", statusi);
        return "narudzba-forma";
    }

    // UPDATE: POST /narudzbe/5/edit
    @PostMapping("/{id}/edit")
    public String izmijeni(@PathVariable Long id,
                           @RequestParam String imeKupca,
                           @RequestParam String email,
                           @RequestParam int kolicina,
                           @RequestParam String status,
                           @RequestParam Long laptopId) {

        Narudzba n = narudzbaService.findById(id);
        if (n == null) {
            return "redirect:/narudzbe";
        }

        // mijenjamo polja postojeceg objekta (datum ostaje isti)
        n.setImeKupca(imeKupca);
        n.setEmail(email);
        n.setKolicina(kolicina);
        n.setStatus(status);
        n.setLaptop(laptopService.findById(laptopId));

        // objekat vec ima id, pa save() radi UPDATE
        narudzbaService.save(n);
        return "redirect:/narudzbe";
    }
}