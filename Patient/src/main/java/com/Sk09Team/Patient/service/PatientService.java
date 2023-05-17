package com.Sk09Team.Patient.service;

import com.Sk09Team.Patient.model.ConsultationRequest;
import org.springframework.http.ResponseEntity;

public interface PatientService {
    ResponseEntity<Long> reserveConsultation(ConsultationRequest consulationRequest);
}
