package com.projects.dogbreeds.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BreedDto {

    private Integer id;
    private String name;
    private String size;
    private Float minWeight;
    private Float maxWeight;
    private Integer lowerAverageAge;
    private Integer higherAverageAge;
    private String temperament;
    private String colorCoat;
    private String origin;
}
