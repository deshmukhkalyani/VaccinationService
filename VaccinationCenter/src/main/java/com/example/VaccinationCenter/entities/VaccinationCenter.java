package com.example.VaccinationCenter.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String centerName;

    private String centerAddress;
}
