package com.example.VaccinationCenter.repository;

import com.example.VaccinationCenter.entities.VaccinationCenter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepo extends JpaRepository<VaccinationCenter, Integer> {
}
