package com.projects.dogbreeds.controller;

import com.projects.dogbreeds.model.Breed;
import com.projects.dogbreeds.repository.BreedsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dogs")
public class BreedsController {

    @GetMapping("all")
    public List<Breed> getAll() {
        return BreedsRepository.breedsRepository;
    }

    @PostMapping("save")
    public Breed save(@RequestBody Breed breed) {
        BreedsRepository.breedsRepository.add(breed);
        return breed;
    }
}
