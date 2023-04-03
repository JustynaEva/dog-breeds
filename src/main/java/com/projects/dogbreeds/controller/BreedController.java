package com.projects.dogbreeds.controller;

import com.projects.dogbreeds.model.dto.BreedDto;
import com.projects.dogbreeds.service.breed.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping("find-by-name/{name}")
    public Set<BreedDto> findByName(@PathVariable String name) {
        return breedService.findBreedsByName(name);
    }

    @GetMapping("find-by-size/{size}")
    public Set<BreedDto> findBySize(@PathVariable String size) {
        return breedService.findBreedsBySize(size);
    }

    @GetMapping("find-by-origin/{origin}")
    public Set<BreedDto> findByOrigin(@PathVariable String origin) {
        return breedService.findBreedsByOrigin(origin);
    }
}
