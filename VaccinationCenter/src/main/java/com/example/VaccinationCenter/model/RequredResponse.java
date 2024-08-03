package com.example.VaccinationCenter.model;

import com.example.VaccinationCenter.entities.VaccinationCenter;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequredResponse {

    private VaccinationCenter center;

    private List<Citizen> citizenList;
}
