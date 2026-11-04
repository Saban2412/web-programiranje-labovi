package com.example.web_programiranje.repository;

import com.example.web_programiranje.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
