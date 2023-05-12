package com.Sk09Team.Consultation.controller;

import com.Sk09Team.Consultation.entity.Consultation;
import com.Sk09Team.Consultation.external.client.response.DoctorResponse;
import com.Sk09Team.Consultation.model.ConsultationRequest;
import com.Sk09Team.Consultation.model.ConsultationResponse;
import com.Sk09Team.Consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ConsultationController {
    @Autowired
    ConsultationService consultationService;

    @GetMapping("/doctor/{city}/{specialty}")
    public ResponseEntity<DoctorResponse> getDoctorsByCityAndSpecialty(@PathVariable("city") String city, @PathVariable("specialty") String specialty) {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getDoctorsByCityAndSpecialty(city, specialty);

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<Long> reserveConsultation(@RequestBody ConsultationRequest consultationRequest){
        long consultationId  =consultationService.reserveConsultation(consultationRequest);
        return new ResponseEntity<>( consultationId, HttpStatus.OK);

    }
    @GetMapping("/doctor/{city}")
    public ResponseEntity<DoctorResponse> getDoctorsByCityAndSpecialty(@PathVariable("city") String city) {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getDoctorsByCity(city);

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }
    @GetMapping("/doctor/{specialty}")
    public ResponseEntity<DoctorResponse> getDoctorsBySpecialty( @PathVariable("specialty") String specialty) {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getDoctorsBySpecialty(specialty);

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }



}








































































































