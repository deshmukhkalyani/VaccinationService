package com.example.VaccinationCenter.controller;

import com.example.VaccinationCenter.entities.VaccinationCenter;
import com.example.VaccinationCenter.model.Citizen;
import com.example.VaccinationCenter.model.RequredResponse;
import com.example.VaccinationCenter.repository.VaccinationRepo;



import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {
    @Autowired
    private VaccinationRepo vaccinationRepo;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path="/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter newVaccinationCenter){
        VaccinationCenter vaccinationCenter = vaccinationRepo.save(newVaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
   // @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id) {
        RequredResponse response = new RequredResponse();

        // 1st get vaccination center details
        VaccinationCenter center = vaccinationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccination center not found with id: " + id));
        response.setCenter(center);

        // then get all citizens registered to the vaccination center
        // connect services -> use RestTemplate

        // get all citizens registered to vaccination center
        List<Citizen> citizenList = restTemplate.getForObject("http://CITIZENSERVICE/citizen/id/" + id, List.class);
        response.setCitizenList(citizenList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//    public ResponseEntity<RequredResponse> handleCitizenDownTime(@PathVariable Integer id){
//        RequredResponse requredResponse = new RequredResponse();
//
//        VaccinationCenter center = vaccinationRepo.findById(id).get();
//               requredResponse.setCenter(center);
//        return new ResponseEntity<RequredResponse>(requredResponse, HttpStatus.OK);
//    }

}
