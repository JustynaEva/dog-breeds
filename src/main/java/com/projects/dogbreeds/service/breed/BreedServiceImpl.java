package com.projects.dogbreeds.service.breed;

import com.projects.dogbreeds.model.dto.BreedDto;
import com.projects.dogbreeds.model.mapper.BreedMapper;
import com.projects.dogbreeds.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
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
    public Set<BreedDto> findBreedByName(String name) {
        return breedRepository.findBreedByNameContaining(name).stream().map(BreedMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public Set<BreedDto> findBreedBySize(String size) {
        return breedRepository.findBreedsBySize(size).stream()
                .map(BreedMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public BreedDto saveBreed(BreedDto breedDto) {
        return BreedMapper.toDto(breedRepository.save(BreedMapper.toEntity(breedDto)));
    }

    @Override
    public BreedDto updateBreed(BreedDto breedDto) {
        breedRepository.findById(breedDto.getId()).ifPresent(breed -> {
            breed.setName(breedDto.getName());
            breed.setSize(breedDto.getSize());
            breed.setMinWeight(breedDto.getMinWeight());
            breed.setMaxWeight(breedDto.getMaxWeight());
            breed.setLowerAverageAge(breedDto.getLowerAverageAge());
            breed.setHigherAverageAge(breedDto.getHigherAverageAge());
            breed.setTemperament(breedDto.getTemperament());
            breed.setColorCoat(breedDto.getColorCoat());
            breed.setOrigin(breedDto.getOrigin());
        });
        return BreedMapper.toDto(breedRepository.getReferenceById(breedDto.getId()));
    }

    @Override
    public BreedDto updateBreedPartial(BreedDto breedDto) {
        breedRepository.findById(breedDto.getId()).ifPresent(breed -> {
            if(breedDto.getName()!=null) {breed.setName(breedDto.getName());}
            if(breedDto.getSize()!=null) {breed.setSize(breedDto.getSize());}
            if(breedDto.getMinWeight()!=null) {breed.setMinWeight(breedDto.getMinWeight());}
            if(breedDto.getMaxWeight()!=null) {breed.setMaxWeight(breedDto.getMaxWeight());}
            if(breedDto.getLowerAverageAge()!=null) {breed.setLowerAverageAge(breedDto.getLowerAverageAge());}
            if(breedDto.getHigherAverageAge()!=null) {breed.setHigherAverageAge(breedDto.getHigherAverageAge());}
            if(breedDto.getTemperament()!=null) {breed.setTemperament(breedDto.getTemperament());}
            if(breedDto.getColorCoat()!=null) {breed.setColorCoat(breedDto.getColorCoat());}
            if(breedDto.getOrigin()!=null) {breed.setOrigin(breedDto.getOrigin());}
        });
        return BreedMapper.toDto(breedRepository.getReferenceById(breedDto.getId()));
    }

    @Override
    public void deleteBreed(Integer id) {
        breedRepository.deleteById(id);
    }
}
