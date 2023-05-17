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

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    @Autowired
    ConsultationService consultationService;

    @GetMapping("/{city}/{specialty}/listDoctors")
    public ResponseEntity<DoctorResponse> getDoctorsByCityAndSpecialty(@PathVariable("city") String city, @PathVariable("specialty") String specialty) {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getDoctorsByCityAndSpecialty(city, specialty);

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<Long> reserveConsultation(@RequestBody ConsultationRequest consultationRequest){
        long consultationId  =consultationService.reserveConsultation(consultationRequest);
        return new ResponseEntity<>( consultationId, HttpStatus.CREATED);

    }
    @GetMapping("/{city}/listDoctors")
    public ResponseEntity<DoctorResponse> getDoctorsByCityAndSpecialty(@PathVariable("city") String city) {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getDoctorsByCity(city);

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }
    @GetMapping("/doctor/{specialty}/listDoctors")
    public ResponseEntity<DoctorResponse> getDoctorsBySpecialty( @PathVariable("specialty") String specialty) {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getDoctorsBySpecialty(specialty);

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }
    @GetMapping("/listDoctors")
    public ResponseEntity<DoctorResponse> getAllDoctors() {
        DoctorResponse doctorResponse
                = (DoctorResponse) consultationService.getAllDoctors();

        return new ResponseEntity<>(doctorResponse,
                HttpStatus.OK);
    }
    @DeleteMapping("/{consultationtId}/{patientId}/delete")
    public ResponseEntity<List<Long>>deleteConsultation(@PathVariable("consultationtId") long  consultationtId ,@PathVariable("patientId") long  patientId){
        List<Long> data = consultationService.deleteConsultation( consultationtId,patientId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PutMapping("/{consultationId}/{doctorId}/approve")
    public ResponseEntity<Long> approveConsultation(@PathVariable("consultationId") long consultationId,@PathVariable("doctorId") long doctorId ){
        long consId = consultationService.approveConsultation(consultationId,doctorId);
        return new ResponseEntity<>(consId,HttpStatus.OK);
    }
    @PutMapping("/{consultationId}/{doctorId}/decline")
    public ResponseEntity<Long> declineConsultation(@PathVariable("consultationId") long consultationId,@PathVariable("doctorId") long doctorId ){
        long consId = consultationService.approveConsultation(consultationId,doctorId);
        return new ResponseEntity<>(consId,HttpStatus.OK);
    }
    @GetMapping("/{doctorId}/listConsultationsForDoctor")
    public ResponseEntity<List<ConsultationResponse>> getAllConsultationsForDoctor(@PathVariable("doctorId") long doctorId) {
        List<ConsultationResponse> consultationResponses= consultationService.getAllConsultationsForDoctor(doctorId);
        return  new ResponseEntity<>(consultationResponses, HttpStatus.OK);
    }
    @GetMapping("/{patientId}/listConsultationsForPatient")
    public ResponseEntity<List<ConsultationResponse>> getAllConsultationsForPatient(@PathVariable("patientId") long doctorId) {
        List<ConsultationResponse> consultationResponses= consultationService.getAllConsultationsForDoctor(doctorId);
        return  new ResponseEntity<>(consultationResponses, HttpStatus.OK);
    }

}








































































































