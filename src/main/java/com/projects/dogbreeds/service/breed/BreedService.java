package com.projects.dogbreeds.service.breed;

import com.projects.dogbreeds.model.entity.Breed;

import java.util.List;

public interface BreedService {

    List<Breed> getAllBreeds();

    Breed saveBreed(Breed breed);
}
