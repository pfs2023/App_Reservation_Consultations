package com.Sk09Team.Doctor.service;
import com.Sk09Team.Doctor.entity.Doctor;
import com.Sk09Team.Doctor.entity.Patient;
import com.Sk09Team.Doctor.external.client.CosnultationClient;
import com.Sk09Team.Doctor.model.ConsultationResponseForDoctor;
import com.Sk09Team.Doctor.model.DoctorRequest;
import com.Sk09Team.Doctor.model.DoctorResponse;
import com.Sk09Team.Doctor.repository.DoctorRepository;
import com.Sk09Team.Doctor.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements  DoctorService {
    @Autowired
    private CosnultationClient consultationClient;
    @Autowired
    private DoctorRepository doctorRepository ;
   @Autowired
    PatientRepository patientRepository;


    @Override
    public ResponseEntity<Long> approveConsultation(long consultationId, long doctorId) {
        return consultationClient.approveConsultation(consultationId, doctorId);
    }
    @Override
   public List<DoctorResponse> getDoctorsByCity(String city) {
         List<Doctor> doctors = doctorRepository.findByCity(city);
         return getDoctorResponses(doctors);
    }
    @Override
    public List<DoctorResponse> getDoctorsBySpecialty(String specialty) {
        List<Doctor> doctors = doctorRepository.findBySpecialty(specialty);
        return getDoctorResponses(doctors);
    }
    @Override
    public List<DoctorResponse> getDoctorsByLastName(String lastName) {
        List<Doctor> doctors = doctorRepository.findByLastName(lastName);
        return getDoctorResponses(doctors);
    }


    @Override
    public ResponseEntity<List<ConsultationResponseForDoctor>> getAllConsultationsForDoctor(long doctorId) {
        List<ConsultationResponseForDoctor> consultations = consultationClient.getAllConsultationsForDoctor(doctorId).getBody();

        assert consultations != null;

        List<Patient> patients = patientRepository.findAll();

        for (ConsultationResponseForDoctor consultation : consultations) {
            String patientCIN = consultation.getPatientCIN();
            boolean patientExists = false;

            for (Patient patient : patients) {
                if (patientCIN.equals(patient.getPatientCIN())) {
                    patientExists = true;
                    break;
                }
            }

            if (!patientExists) {
                // Patient does not exist, create a new patient entity
                Patient newPatient = Patient.builder()
                        .patientCIN(patientCIN)
                        .patientFirstName(consultation.getPatientFirstName())
                        .patientLastName(consultation.getPatientLastName())
                        .patientGender(consultation.getPatientGender())
                        .patientPhone(consultation.getPatientPhone())
                        .patientbirthDate(consultation.getPatientbirthDate())
                        .patientPostCode(consultation.getPatientPostCode())
                        .patientEmail(consultation.getPatientEmail())
                        .patientCity(consultation.getPatientCity())
                        .patientAddress(consultation.getPatientAddress())
                        .build();

                patientRepository.save(newPatient);
            }
        }

        return ResponseEntity.ok(consultations);
    }


    @Override
   public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return getDoctorResponses(doctors);
    }

    @Override
   public List<DoctorResponse> getDoctorsByCityAndSpecialty(String city, String specialty) {
        List<Doctor> doctors = doctorRepository.findByCityAndSpecialty(city, specialty);
        return getDoctorResponses(doctors);

    }

    @Override
    public long registerDoctor(DoctorRequest doctorRequest) {
        Doctor doctor=Doctor.builder()
                .firstName(doctorRequest.getFirstName())
                .lastName(doctorRequest.getLastName())
                .city(doctorRequest.getCity())
                .specialty(doctorRequest.getSpecialty())
                .postCode(doctorRequest.getPostCode())
                .address(doctorRequest.getAddress())
                .password(doctorRequest.getPassword())
                .build();

        doctorRepository.save(doctor);
        return doctor.getDoctorId();
    }


    private List<DoctorResponse> getDoctorResponses(List<Doctor> doctors) {
        List<DoctorResponse> doctorsResponses = new ArrayList<>();
        for (Doctor doctor : doctors) {
           DoctorResponse doctorResponse = DoctorResponse.builder()
                   .doctorEmail(doctor.getDoctorEmail())
                   .doctorPhone(doctor.getDoctorPhone())
                   .address(doctor.getAddress())
                   .place(doctor.getPlace())
                   .city(doctor.getCity())
                   .location(doctor.getLocation())
                   .firstName(doctor.getFirstName())
                   .languages(doctor.getLanguages())
                   .diplomas(doctor.getDiplomas())
                   .lastName(doctor.getLastName())
                   .paymentMode(doctor.getPaymentMode())
                   .specialty(doctor.getSpecialty())
                   .calendar(doctor.getCalendar())
                   .doctorId(doctor.getDoctorId())
                   .build();
            doctorsResponses.add(doctorResponse);
        }
        return doctorsResponses;
    }
}
