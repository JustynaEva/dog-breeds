package com.projects.dogbreeds.controller;

import com.projects.dogbreeds.model.Breed;
import com.projects.dogbreeds.repository.BreedsRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dogs")
public class BreedsController {

    @GetMapping("all")
    public List<Breed> getAll()
    {
        return BreedsRepository.breedsRepository;
    }

    @PostMapping("save")
    public Breed save(@RequestBody Breed breed) {
        BreedsRepository.breedsRepository.add(breed);
        return breed;
    }
    @PutMapping("update")
    public String updateWithFullBody (@RequestBody Breed breed, HttpServletResponse response) {
        if (BreedsRepository.breedsRepository.size() - 1 < breed.getId()) {
            return getResponseUnknownBreed(response);
        } else {
            BreedsRepository.breedsRepository.set(breed.getId(), breed);
        }
        return "Breed " + breed.getName() + " is updated.";
    }

    //    private String origin;

    @PatchMapping("update")
    public String updatePartial(@RequestBody Breed breed, HttpServletResponse response) {
        if (BreedsRepository.breedsRepository.size() - 1 < breed.getId()) {
            return getResponseUnknownBreed(response);
        } else {

            Breed breedInRepo = BreedsRepository.breedsRepository.get(breed.getId());

            if (breed.getName() != null) {
                breedInRepo.setName(breed.getName());
            }
            if (breed.getSize() != null) {
                breedInRepo.setSize(breed.getSize());
            }
            if (breed.getMaleWeight() != null) {
                breedInRepo.setMaleWeight(breed.getMaleWeight());
            }
            if (breed.getFemaleWeight() != null) {
                breedInRepo.setFemaleWeight(breed.getFemaleWeight());
            }
            if (breed.getLowerAverageAge() != null) {
                breedInRepo.setLowerAverageAge(breed.getLowerAverageAge());
            }
            if (breed.getHigherAverageAge() != null) {
                breedInRepo.setHigherAverageAge(breed.getHigherAverageAge());
            }
            if (breed.getCharacterTraits() != null) {
                breedInRepo.setCharacterTraits(breed.getCharacterTraits());
            }
            if (breed.getCoatType() != null) {
                breedInRepo.setCoatType(breed.getCoatType());
            }
            if (breed.getColorCoat() != null) {
                breedInRepo.setColorCoat(breed.getColorCoat());
            }
            if (breed.getOrigin() != null) {
                breedInRepo.setOrigin(breed.getOrigin());
            }

            return "Breed " + breedInRepo.getName() + " is partially updated.";
        }
    }
    private static String getResponseUnknownBreed(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return "Breed is not recognized.Try to add a new breed.";
    }

}
