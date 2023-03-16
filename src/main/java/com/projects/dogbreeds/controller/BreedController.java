package com.projects.dogbreeds.controller;

import com.projects.dogbreeds.model.dto.BreedDto;
import com.projects.dogbreeds.service.breed.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dogs")
@RequiredArgsConstructor
public class BreedController {
    private final BreedService breedService;

    @GetMapping("all")
    public List<BreedDto> getAll() {
        return breedService.getAllBreeds();
    }
    @PostMapping("save")
    public BreedDto save(@RequestBody BreedDto breedDto) {
        return breedService.saveBreed(breedDto);
    }
    @PutMapping("update")
    public BreedDto update (@RequestBody BreedDto breedDto) {

        return breedService.updateBreed(breedDto);
    }
    @PatchMapping("update")
    public BreedDto updatePartial(@RequestBody BreedDto breedDto) {
            return breedService.updateBreedPartial(breedDto);
    }
    @DeleteMapping("delete/{id}")
    public String deleteBreed(@PathVariable int id) {
        breedService.deleteBreed(id);
        return "Breed removed.";
    }
}
