package com.Sk09Team.Consultation.service;

import com.Sk09Team.Consultation.entity.Consultation;
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

    List<Long> deleteConsultation(long consultationtId, long patientId);

   long  approveConsultation(long consultationId, long doctorId);
    long  declineConsultation(long consultationId, long doctorId);

    List<ConsultationResponse> getAllConsultationsForDoctor(long doctorId);
    List<ConsultationResponse> getAllConsultationsForPatient(long patientId);
}
