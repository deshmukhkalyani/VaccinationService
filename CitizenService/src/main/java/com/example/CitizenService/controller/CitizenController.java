package com.example.CitizenService.controller;

import com.example.CitizenService.entity.Citizen;
import com.example.CitizenService.reopository.CitizenRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepo citizenRepo;

   @RequestMapping(path="/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hello ", HttpStatus.OK);
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
//        List<Citizen> citizenList = citizenRepo.findbyvaccinationCenterId(id);
//        return new ResponseEntity<>(citizenList, HttpStatus.OK);
//    }
    @PostMapping(path="/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
        Citizen citizen = citizenRepo.save(newCitizen);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> findByVaccinationCenterId(@PathVariable Integer id) {
        List<Citizen> citizens = citizenRepo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

}
