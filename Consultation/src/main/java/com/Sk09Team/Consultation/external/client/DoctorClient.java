package com.Sk09Team.Consultation.external.client;
import com.Sk09Team.Consultation.external.client.response.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorCleint {
    @GetMapping("/doctors")
    List<DoctorResponse> getDoctorsByCityAndSpecialty(@RequestParam String city, @RequestParam String specialty);
}
