package com.projects.dogbreeds.service.breed;

import com.projects.dogbreeds.model.entity.Breed;
import com.projects.dogbreeds.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BreedServiceImpl implements BreedService{

   private final BreedRepository breedRepository;

    @Override
    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    @Override
    public Breed saveBreed(Breed breed) {
        return breedRepository.save(breed);
    }
}
