package com.projects.dogbreeds.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Breed {

    private Integer id;
    private String name;
    private String size;
    private Integer maleWeight;
    private Integer femaleWeight;
    private Integer lowerAverageAge;
    private Integer higherAverageAge;
    private String characterTraits;
    private String coatType;
    private String colorCoat;
    private String origin;
}
