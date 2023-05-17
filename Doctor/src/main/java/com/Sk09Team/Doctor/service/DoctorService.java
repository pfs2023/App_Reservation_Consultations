package com.Sk09Team.Doctor.service;

import org.springframework.http.ResponseEntity;

public interface DoctorService {
    ResponseEntity<Long> approveConsultation(long consultationId, long doctorId);
}

