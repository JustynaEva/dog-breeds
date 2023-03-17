package com.projects.dogbreeds.service.breed;

import com.projects.dogbreeds.model.dto.BreedDto;

import java.util.List;
import java.util.Set;

public interface BreedService {

    List<BreedDto> getAllBreeds();

    Set<BreedDto> findBreedByName(String name);

    Set<BreedDto> findBreedBySize(String size);

    BreedDto saveBreed(BreedDto breedDto);

    BreedDto updateBreed(BreedDto breedDto);

    BreedDto updateBreedPartial(BreedDto breedDto);

    void deleteBreed(Integer id);
}
