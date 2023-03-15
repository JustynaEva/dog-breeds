package com.projects.dogbreeds.repository;

import com.projects.dogbreeds.model.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedsRepository extends JpaRepository<Breed,Integer> {

}
