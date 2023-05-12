package com.Sk09Team.Consultation.service;

import com.Sk09Team.Consultation.external.client.response.DoctorResponse;
import com.Sk09Team.Consultation.model.ConsultationRequest;
import com.Sk09Team.Consultation.model.ConsultationResponse;

import java.util.List;

public interface ConsultationService {
    List<DoctorResponse> getDoctorsByCityAndSpecialty(String city, String specialty);

    long reserveConsultation(ConsultationRequest consultationRequest);

    List<DoctorResponse> getDoctorsByCity(String city);

    List<DoctorResponse>getDoctorsBySpecialty(String specialty);
    long getPatientById(long patientId);
    List<DoctorResponse> getAllDoctors();
}
