package com.projects.dogbreeds.service.breed;

import com.projects.dogbreeds.model.dto.BreedDto;

import java.util.List;

public interface BreedService {

    List<BreedDto> getAllBreeds();

    BreedDto saveBreed(BreedDto breedDto);

    BreedDto updateBreed(BreedDto breedDto);

    BreedDto updateBreedPartial(BreedDto breedDto);

    void deleteBreed(Integer id);
}
