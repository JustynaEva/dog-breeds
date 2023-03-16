package com.projects.dogbreeds.model.mapper;

import com.projects.dogbreeds.model.dto.BreedDto;
import com.projects.dogbreeds.model.entity.Breed;
import org.springframework.stereotype.Component;


public interface BreedMapper {

    static BreedDto toDto(Breed breed) {
        return BreedDto.builder()
                .id(breed.getId())
                .name(breed.getName())
                .size(breed.getSize())
                .minWeight(breed.getMinWeight())
                .maxWeight(breed.getMaxWeight())
                .lowerAverageAge(breed.getLowerAverageAge())
                .higherAverageAge(breed.getHigherAverageAge())
                .temperament(breed.getTemperament())
                .colorCoat(breed.getColorCoat())
                .origin(breed.getOrigin()).build();
    }

    static Breed toEntity (BreedDto breedDto){
    return Breed.builder()
            .name(breedDto.getName())
            .size(breedDto.getSize())
            .minWeight(breedDto.getMinWeight())
            .maxWeight(breedDto.getMaxWeight())
            .lowerAverageAge(breedDto.getLowerAverageAge())
            .higherAverageAge(breedDto.getHigherAverageAge())
            .temperament(breedDto.getTemperament())
            .colorCoat(breedDto.getColorCoat())
            .origin(breedDto.getOrigin()).build();
    }
}
