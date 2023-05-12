package com.Sk09Team.Consultation.external.client.response;

import com.Sk09Team.Consultation.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DoctorResponse {
    private long doctorId;
    private String city ;
    private String specialty ;
    private String doctorName ;
    private String location ;
    private List<String> diplomas;
    private String address ;
    private String place;
    private PaymentMode paymentMode;
    private List<String> language ;

}
