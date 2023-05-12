package com.Sk09Team.Consultation.external.client;
import com.Sk09Team.Consultation.external.client.response.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorClient {
    @GetMapping
    List<DoctorResponse> getDoctorsByCityAndSpecialty(@PathVariable String city, @PathVariable String specialty);
    @GetMapping
    List<DoctorResponse> getDoctorByCity(@PathVariable String city);
    @GetMapping
    List<DoctorResponse>getDoctorBySpecialty(@PathVariable String specialty);
    List<DoctorResponse> getAllDoctors();


}
