package com.Sk09Team.Patient.controller;

import com.Sk09Team.Patient.model.ConsultationRequest;
import com.Sk09Team.Patient.service.PatientService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")

public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/reserve")
    public ResponseEntity<Long> reserveConsultation(@RequestBody ConsultationRequest consulationRequest){
        return patientService.reserveConsultation(consulationRequest);

    }

}
