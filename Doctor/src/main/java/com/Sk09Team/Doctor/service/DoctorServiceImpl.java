package com.Sk09Team.Doctor.service;


import com.Sk09Team.Doctor.external.client.CosnultationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class DoctorServiceImpl implements  DoctorService {
@Autowired
    private CosnultationClient consultationClient;
    @Override
    public ResponseEntity<Long> approveConsultation(long consultationId, long doctorId) {
        return consultationClient.approveConsultation(consultationId, doctorId);
    }

}
