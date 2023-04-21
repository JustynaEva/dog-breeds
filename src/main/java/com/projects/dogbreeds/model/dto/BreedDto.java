package com.projects.dogbreeds.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BreedDto {

    private Integer id;
    @NotNull(message = "Name is required.")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters.")
    private String name;
    @NotNull(message = "Size is required.")
    private String size;
    private Float minWeight;
    private Float maxWeight;
    private Integer lowerAverageAge;
    private Integer higherAverageAge;
    private String temperament;
    private String colorCoat;
    private String origin;
}
