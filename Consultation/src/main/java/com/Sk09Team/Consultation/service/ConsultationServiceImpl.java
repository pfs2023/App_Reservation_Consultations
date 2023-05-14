package com.Sk09Team.Consultation.service;

import com.Sk09Team.Consultation.entity.Consultation;
import com.Sk09Team.Consultation.external.client.DoctorClient;
import com.Sk09Team.Consultation.external.client.PatientClient;
import com.Sk09Team.Consultation.external.client.response.DoctorResponse;
import com.Sk09Team.Consultation.model.ConsultationRequest;
import com.Sk09Team.Consultation.model.ConsultationResponse;
import com.Sk09Team.Consultation.model.ConsultationStatus;
import com.Sk09Team.Consultation.repository.ConsultationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    //@Autowired
    private PatientClient patientClient;


    @Autowired
     private ConsultationRepository consultationRepository;
   // @Autowired
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
                .specialty(consultationRequest.getSpecialty())
                .startAt(consultationRequest.getStartAt())
                .doctorId(consultationRequest.getDoctorId())
                .medical_info(consultationRequest.getMedical_info())
                .location(consultationRequest.getLocation())
                .consultationStatus(consultationRequest.getConsultationStatus())
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

    @Override
    public List<Long> deleteConsultation(long consultationtId, long patientId) {
        List<Long> consultationSpecs = new ArrayList<>();
        consultationSpecs.add(consultationtId);
        consultationSpecs.add(patientId);
        consultationRepository.deleteByConsultationIdAndPatientId( consultationtId,patientId);
        return consultationSpecs;
    }
    @Override
    public long approveConsultation(long consultationId, long doctorId){
        Consultation consultation = consultationRepository.findByIdAndDoctorId(consultationId, doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found with id " + consultationId + " and doctor id " + doctorId));
        consultation.setConsultationStatus(ConsultationStatus.APPROVED);
        consultationRepository.save(consultation);
        return consultation.getId();
    }
    @Override
    public long declineConsultation(long consultationId, long doctorId) {      Consultation consultation = consultationRepository.findByIdAndDoctorId(consultationId, doctorId)
            .orElseThrow(() -> new EntityNotFoundException("Consultation not found with id " + consultationId + " and doctor id " + doctorId));
        consultation.setConsultationStatus(ConsultationStatus.DECLINED);
        consultationRepository.save(consultation);
        return consultation.getId();
    }

    @Override
    public List<ConsultationResponse> getAllConsultationsForDoctor(long doctorId) {
        List<Consultation> consultations = consultationRepository.findByDoctorId(doctorId);
        return getConsultationResponses(consultations);
    }

    @Override
    public List<ConsultationResponse> getAllConsultationsForPatient(long patientId) {
        List<Consultation> consultations = consultationRepository.findByPatientId(patientId);
        return getConsultationResponses(consultations);

    }

    private List<ConsultationResponse> getConsultationResponses(List<Consultation> consultations) {
        List<ConsultationResponse> consultationResponses = new ArrayList<>();
        for (Consultation consultation : consultations) {
            ConsultationResponse consultationResponse = ConsultationResponse.builder()
                    .doctorName(consultation.getDoctorName())
                    .doctorId(consultation.getDoctorId())
                    .place(consultation.getPlace())
                    .motif(consultation.getMotif())
                    .startAt(consultation.getStartAt())
                    .medical_info(consultation.getMedical_info())
                    .location(consultation.getLocation())
                    .patientId(consultation.getPatientId())
                    .specialty(consultation.getSpecialty())
                    .build();
            consultationResponses.add(consultationResponse);

        }
        return consultationResponses;
    }

}
