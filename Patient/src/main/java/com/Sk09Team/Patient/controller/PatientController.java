package com.Sk09Team.Patient.controller;
import com.Sk09Team.Patient.external.response.DoctorResponse;
import com.Sk09Team.Patient.model.ConsultationRequest;
import com.Sk09Team.Patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/reserve")
    public ResponseEntity<Long> reserveConsultation(@RequestBody ConsultationRequest consulationRequest){
        return patientService.reserveConsultation(consulationRequest);
    }
    @GetMapping("/{city}/{specialty}/listDoctorsByCityAndSpecialty")
    public ResponseEntity<List<DoctorResponse>> getDoctorsByCityAndSpecialty(@PathVariable("city") String city, @PathVariable("specialty") String specialty) {
      return  patientService.getDoctorsByCityAndSpecialty(city,specialty);
    }
    @GetMapping("/{city}/listDoctorsByCity")
    public ResponseEntity<List<DoctorResponse>> getDoctorsByCity(@PathVariable("city") String city) {
        return  patientService.getDoctorsByCity(city);
    }
    @GetMapping("/{specialty}/listDoctorsBySpecialty")
    public ResponseEntity<List<DoctorResponse>> getDoctorsBySpecialty( @PathVariable("specialty") String specialty) {
        return  patientService.getDoctorsBySpecialty(specialty);
    }
    @GetMapping("/listDoctors")
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return  patientService.getAllDoctors();
    }

}
