package com.Sk09Team.Consultation.external.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@CircuitBreaker(name="external",fallbackMethod = "fallback")
@FeignClient(name = "PATIENT-SERVICE")
public interface PatientClient {
    @GetMapping("/patient/{patientId}")
    Long  getPatientId(@PathVariable("patientId")  long patientId);
    default void fallback(Exception e){
        throw new RuntimeException("Patient Service is not available!");

    }
}
