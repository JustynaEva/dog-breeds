package com.projects.dogbreeds.repository;

import com.projects.dogbreeds.model.Breed;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BreedsRepository implements CommandLineRunner {

    public static ArrayList<Breed> breedsRepository = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        breedsRepository.add(Breed.builder().id(0).name("Labrador Retriever").size("Large").lowerAverageAge(10).higherAverageAge(12).coatType("short hair").characterTraits("friendly,gentle,crazy").femaleWeight(30).maleWeight(35).origin("Canada").colorCoat("black, brown, yellow").build());
        breedsRepository.add(Breed.builder().id(1).name("German Shepherd").size("Large").lowerAverageAge(10).higherAverageAge(12).coatType("short hair").characterTraits("friendly,gentle,loyal").femaleWeight(30).maleWeight(35).origin("Germany").colorCoat("black, brown, yellow").build());
    }
}
