package com.Sk09Team.Patient.service;

import com.Sk09Team.Patient.external.client.ConsultationClient;
import com.Sk09Team.Patient.model.ConsultationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements  PatientService{
    @Autowired
    ConsultationClient consultationClient;

    @Override
    public ResponseEntity<Long> reserveConsultation(ConsultationRequest consulationRequest) {
        return consultationClient.reserveConsultation(consulationRequest);
    }
}
