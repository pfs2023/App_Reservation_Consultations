package com.Sk09Team.Doctor.service;
import ch.qos.logback.core.net.server.Client;
import com.Sk09Team.Doctor.entity.Doctor;
import com.Sk09Team.Doctor.external.client.CosnultationClient;
import com.Sk09Team.Doctor.model.DoctorRequest;
import com.Sk09Team.Doctor.model.DoctorResponse;
import com.Sk09Team.Doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class DoctorServiceImpl implements  DoctorService {
    @Autowired
    private CosnultationClient consultationClient;
    @Autowired
    private DoctorRepository doctorRepository ;


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
