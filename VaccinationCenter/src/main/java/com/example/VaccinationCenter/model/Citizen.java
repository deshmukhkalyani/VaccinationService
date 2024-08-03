package com.example.VaccinationCenter.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @Column
    private String name;
    @Column
    private Integer vaccinationCenterId;
}
