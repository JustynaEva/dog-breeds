package com.projects.dogbreeds.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "dog_breed")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
