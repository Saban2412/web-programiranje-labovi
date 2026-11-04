package com.example.web_programiranje.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "narudzbe")
public class Narudzba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imeKupca;
    private String email;
    private int kolicina;
    private LocalDate datum;
    private String status;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    public Narudzba(){}

    public Long getId(){return id;}
    public void setId(Long Id){this.id = id;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getImeKupca(){return imeKupca;}
    public void setImeKupca(String imeKupca){this.imeKupca=imeKupca;}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}

    public int kolicina(){return kolicina;}
    public void setKolicina(int kolicina){this.kolicina=kolicina;}

    public LocalDate getDatum(){return datum;}
    public void setDatum(LocalDate datum){this.datum=datum;}

    public Laptop getLaptop(){return laptop;}
    public void setLaptop(Laptop laptop){this.laptop=laptop;}

}
