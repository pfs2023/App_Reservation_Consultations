package com.Sk09Team.Patient.external.client;

import com.Sk09Team.Patient.model.ConsultationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name="CONSULTATION-SERVICE/consultation")
public interface ConsultationClient {
    @PostMapping("/reserve")
   ResponseEntity<Long> reserveConsultation(@RequestBody ConsultationRequest consultationRequest);
}
