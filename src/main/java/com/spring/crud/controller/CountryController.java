package com.spring.crud.controller;

import com.spring.crud.entities.Country;
import com.spring.crud.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("country", countryRepository.findAll(
                PageRequest.of(page, 3)));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @PostMapping("/save")
    public String save(Country c) {
        countryRepository.save(c);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(Integer id) {
        countryRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/country")
    @ResponseBody
    public Optional<Country> findOne(Integer id) {
        return countryRepository.findById(id);
    }


}
