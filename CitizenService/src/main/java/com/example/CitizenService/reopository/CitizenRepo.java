package com.example.CitizenService.reopository;

import com.example.CitizenService.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

    List<Citizen> findByVaccinationCenterId(Integer vaccinationCenterId);

}
