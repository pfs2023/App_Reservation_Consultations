package com.Sk09Team.Doctor.entity;

import com.Sk09Team.Doctor.model.PaymentMode;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Doctor {
    @Id
    private Long doctorId;
    @Column(name="firstName")
    private String firstName ;
    @Column(name="lastName")
    private String lastName ;
    @Column(name="password")
    private String password ;
    @Column(name="registrationNumber")
    private String registrationNumber ;
    @Column(name="address")
    private String address ;
    @Column(name="city")
    private String city ;
    @Column(name="specialty")
    private String specialty ;
    @Column(name="location")
    private String location ;
    @Column(name="diplomas")
    @ElementCollection
    private List<String> diplomas;
    @Column(name="place")
    private String place;
    @Column(name="paymentMode")
    private PaymentMode paymentMode;
    @Column(name="languages")
    @ElementCollection
    private List<String> languages;
}


