package com.projects.dogbreeds.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Breed {

    private String name;
    private int maleWeight;
    private int femaleWeight;
    private int lowerAverageAge;
    private int higherAverageAge;
    private String characterTraits;
    private String coatType;
    private String colorCoat;
    private String origin;
}
