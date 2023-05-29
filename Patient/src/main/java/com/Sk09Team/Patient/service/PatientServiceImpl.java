package com.Sk09Team.Patient.service;

import com.Sk09Team.Patient.external.client.ConsultationClient;
import com.Sk09Team.Patient.external.client.DoctorClient;
import com.Sk09Team.Patient.external.response.DoctorResponse;
import com.Sk09Team.Patient.model.ConsultationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements  PatientService{
    @Autowired
    ConsultationClient consultationClient;
    @Autowired
    DoctorClient doctorClient;

    @Override
    public ResponseEntity<Long> reserveConsultation(ConsultationRequest consulationRequest) {
        return consultationClient.reserveConsultation(consulationRequest);
    }

    @Override
    public ResponseEntity<List<DoctorResponse>> getDoctorsByCityAndSpecialty(String city, String specialty) {
        return doctorClient.getDoctorsByCityAndSpecialty(city, specialty);
    }

    @Override
    public ResponseEntity<List<DoctorResponse>> getDoctorsByCity(String city) {
        return doctorClient.getDoctorsByCity( city);
    }

    @Override
    public ResponseEntity<List<DoctorResponse>> getDoctorsBySpecialty(String specialty) {
        return doctorClient.getDoctorsBySpecialty(specialty);
    }

    @Override
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return doctorClient.getAllDoctors();
    }
}
