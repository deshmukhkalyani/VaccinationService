package com.example.CitizenService.entity;

import jakarta.persistence.*;
import lombok.*;

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
