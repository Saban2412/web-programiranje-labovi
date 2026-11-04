package com.example.web_programiranje.controller;

import com.example.web_programiranje.model.Accessory;
import com.example.web_programiranje.model.Laptop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "redirect:/a";
    }

    @GetMapping("/a")
    public String listA(Model model) {
        model.addAttribute("laptops", DemoData.laptops);
        return "listA";
    }

    @GetMapping("/b")
    public String listB(Model model) {
        model.addAttribute("accessories", DemoData.accessories);
        return "listB";
    }

    @GetMapping("/a/action/{id}")
    public String action(@PathVariable int id,
                         @RequestParam(required = false) List<Integer> selected,
                         Model model) {

        Laptop laptop = null;
        for (Laptop l : DemoData.laptops) {
            if (l.getId() == id) {
                laptop = l;
            }
        }
        if (laptop == null) {
            return "redirect:/a";
        }

        if (selected == null) {
            selected = new ArrayList<>();
        }

        double accessoriesTotal = 0;
        for (Accessory a : laptop.getAccessories()) {
            if (selected.contains(a.getId())) {
                accessoriesTotal = accessoriesTotal + a.getPrice();
            }
        }

        boolean discount = selected.size() >= 2;
        double discountAmount = 0;
        if (discount) {
            discountAmount = accessoriesTotal * 0.10;
        }

        double total = laptop.getPrice() + accessoriesTotal - discountAmount;

        model.addAttribute("laptop", laptop);
        model.addAttribute("selectedIds", selected);
        model.addAttribute("accessoriesTotal", accessoriesTotal);
        model.addAttribute("discount", discount);
        model.addAttribute("discountAmount", discountAmount);
        model.addAttribute("total", total);
        return "action";
    }
}