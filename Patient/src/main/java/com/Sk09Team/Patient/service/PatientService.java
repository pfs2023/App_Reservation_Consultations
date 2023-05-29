package com.Sk09Team.Patient.service;

import com.Sk09Team.Patient.external.response.DoctorResponse;
import com.Sk09Team.Patient.model.ConsultationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    ResponseEntity<Long> reserveConsultation(ConsultationRequest consulationRequest);

    ResponseEntity<List<DoctorResponse>> getDoctorsByCityAndSpecialty(String city, String specialty);

    ResponseEntity<List<DoctorResponse>> getDoctorsByCity(String city);

    ResponseEntity<List<DoctorResponse>> getDoctorsBySpecialty(String specialty);

    ResponseEntity<List<DoctorResponse>> getAllDoctors();
}
