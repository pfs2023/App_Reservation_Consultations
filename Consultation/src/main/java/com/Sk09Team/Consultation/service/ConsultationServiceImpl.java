package com.Sk09Team.Consultation.service;

import com.Sk09Team.Consultation.entity.Consultation;
import com.Sk09Team.Consultation.external.client.DoctorClient;
import com.Sk09Team.Consultation.external.client.PatientClient;
import com.Sk09Team.Consultation.external.client.response.DoctorResponse;
import com.Sk09Team.Consultation.model.ConsultationRequest;
import com.Sk09Team.Consultation.model.ConsultationResponse;
import com.Sk09Team.Consultation.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private PatientClient patientClient;


    @Autowired
     private ConsultationRepository consultationRepository;
    @Autowired
    private  DoctorClient doctorClient;

    @Override
    public List<DoctorResponse> getDoctorsByCityAndSpecialty(String city, String specialty) {
        return doctorClient.getDoctorsByCityAndSpecialty(city, specialty);
    }

    @Override
    public long reserveConsultation(ConsultationRequest consultationRequest) {
        Consultation consultation = Consultation.builder()
                .doctorName(consultationRequest.getDoctorName())
                .patientId(consultationRequest.getPatientId())
                .motif(consultationRequest.getMotif())
                .place(consultationRequest.getPlace())
                .speciality(consultationRequest.getSpecialty())
                .startAt(consultationRequest.getStartAt())
                .doctorId(consultationRequest.getDoctorId())
                .medical_info(consultationRequest.getMedical_info())
                .location(consultationRequest.getLocation())
                .build();
               consultationRepository.save(consultation);
               return consultation.getId();

    }
    public  List<DoctorResponse> getDoctorsByCity(String city){
        return doctorClient.getDoctorByCity(city);

    }

    @Override
    public List<DoctorResponse> getDoctorsBySpecialty(String specialty) {
        return doctorClient.getDoctorBySpecialty(specialty);
    }
    @Override
    public  long getPatientById(long patientId){
       return patientClient.getPatientId(patientId);
    }
    @Override
    public List<DoctorResponse> getAllDoctors(){
        return doctorClient.getAllDoctors();
    }
}
