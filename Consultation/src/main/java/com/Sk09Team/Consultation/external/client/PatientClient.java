package com.Sk09Team.Consultation.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientClient {
    @GetMapping("/patient/{patientId}")
    Long  getPatientId(@PathVariable("patientId")  long patientId);

}
