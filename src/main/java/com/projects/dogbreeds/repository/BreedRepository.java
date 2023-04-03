package com.projects.dogbreeds.repository;

import com.projects.dogbreeds.model.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BreedRepository extends JpaRepository<Breed,Integer> {

    Set<Breed> findBreedsByNameContaining(String name);

    Set<Breed> findBreedsBySize(String size);

    @Query("SELECT b FROM Breed b WHERE b.origin = :origin")
    Set<Breed> findBreedsByOrigin(@Param("origin") String origin);

}
