package com.projects.dogbreeds.service.breed;

import com.projects.dogbreeds.exception.exceptions.BreedNotFoundException;
import com.projects.dogbreeds.exception.messages.BreedControllerExceptionMessages;
import com.projects.dogbreeds.model.dto.BreedDto;
import com.projects.dogbreeds.model.entity.Breed;
import com.projects.dogbreeds.model.mapper.BreedMapper;
import com.projects.dogbreeds.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class BreedServiceImpl implements BreedService{

   private final BreedRepository breedRepository;

    @Override
    public List<BreedDto> getAllBreeds() {
        return breedRepository.findAll().stream()
                .map(BreedMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Set<BreedDto> findBreedsByName(String name) {
        Set<Breed> breeds = breedRepository.findBreedsByNameContaining(name);
        if(breeds.isEmpty()){
            throw new BreedNotFoundException(BreedControllerExceptionMessages
                    .ENTITY_FOR_PROVIDED_NAME_NOT_EXIST.getMessage());
        }
        return breeds.stream().map(BreedMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public Set<BreedDto> findBreedsBySize(String size) {
        Set<Breed> breeds = breedRepository.findBreedsBySize(size);
        if (breeds.isEmpty()) {
            throw new BreedNotFoundException(BreedControllerExceptionMessages
                    .ENTITY_FOR_PROVIDED_SIZE_NOT_EXIST.getMessage());
        }
        return breeds.stream()
                .map(BreedMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public Set<BreedDto> findBreedsByOrigin(String origin) {
        Set<Breed> breeds = breedRepository.findBreedsByOrigin(origin);
        if(breeds.isEmpty()) {
            throw new BreedNotFoundException(BreedControllerExceptionMessages
                    .ENTITY_FOR_PROVIDED_ORIGIN_NOT_EXIST.getMessage());
        }
        return breeds.stream()
                .map(BreedMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public BreedDto saveBreed(BreedDto breedDto) {
        return BreedMapper.toDto(breedRepository.save(BreedMapper.toEntity(breedDto)));
    }

    @Override
    public BreedDto updateBreed(BreedDto breedDto) {
        return breedRepository.findById(breedDto.getId()).map(breed -> {
            breed.setName(breedDto.getName());
            breed.setSize(breedDto.getSize());
            breed.setMinWeight(breedDto.getMinWeight());
            breed.setMaxWeight(breedDto.getMaxWeight());
            breed.setLowerAverageAge(breedDto.getLowerAverageAge());
            breed.setHigherAverageAge(breedDto.getHigherAverageAge());
            breed.setTemperament(breedDto.getTemperament());
            breed.setColorCoat(breedDto.getColorCoat());
            breed.setOrigin(breedDto.getOrigin());
            return BreedMapper.toDto(breed);
        }).orElseThrow(()-> new BreedNotFoundException(BreedControllerExceptionMessages
                .ENTITY_FOR_PROVIDED_ID_NOT_EXIST.getMessage()));
    }

    @Override
    public BreedDto updateBreedPartial(BreedDto breedDto) {
        return breedRepository.findById(breedDto.getId()).map(breed -> {
            if (breedDto.getName() != null) {
                breed.setName(breedDto.getName());
            }
            if (breedDto.getSize() != null) {
                breed.setSize(breedDto.getSize());
            }
            if (breedDto.getMinWeight() != null) {
                breed.setMinWeight(breedDto.getMinWeight());
            }
            if (breedDto.getMaxWeight() != null) {
                breed.setMaxWeight(breedDto.getMaxWeight());
            }
            if (breedDto.getLowerAverageAge() != null) {
                breed.setLowerAverageAge(breedDto.getLowerAverageAge());
            }
            if (breedDto.getHigherAverageAge() != null) {
                breed.setHigherAverageAge(breedDto.getHigherAverageAge());
            }
            if (breedDto.getTemperament() != null) {
                breed.setTemperament(breedDto.getTemperament());
            }
            if (breedDto.getColorCoat() != null) {
                breed.setColorCoat(breedDto.getColorCoat());
            }
            if (breedDto.getOrigin() != null) {
                breed.setOrigin(breedDto.getOrigin());
            }
            return BreedMapper.toDto(breed);
        }).orElseThrow(()-> new BreedNotFoundException(BreedControllerExceptionMessages
                .ENTITY_FOR_PROVIDED_ID_NOT_EXIST.getMessage()));
    }

    @Override
    public void deleteBreed(Integer id) {
        if(breedRepository.findById(id).isEmpty()){
            throw new BreedNotFoundException(BreedControllerExceptionMessages
                    .ENTITY_FOR_PROVIDED_ID_NOT_EXIST.getMessage());
        } else {
            breedRepository.deleteById(id);
        }

    }
}
