package com.Sk09Team.Doctor.service;

import com.Sk09Team.Doctor.entity.Doctor;
import com.Sk09Team.Doctor.model.DoctorRequest;
import com.Sk09Team.Doctor.model.DoctorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface DoctorService {
    ResponseEntity<Long> approveConsultation(long consultationId, long doctorId);

    List<DoctorResponse> getDoctorsByCity(String city);

    List<DoctorResponse> getDoctorsBySpecialty(String specialty);

    List<DoctorResponse> getAllDoctors();

    List<DoctorResponse> getDoctorsByCityAndSpecialty(String city, String specialty);

    long registerDoctor(DoctorRequest doctorRequest);
}

