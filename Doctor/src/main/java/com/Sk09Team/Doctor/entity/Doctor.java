package com.Sk09Team.Doctor.entity;

import com.Sk09Team.Doctor.model.PaymentMode;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name="email")
    private String doctorEmail;
    @Column(name="phone")
    private String doctorPhone;
    @Column(name="city")
    private String city ;
    @Column(name="post_code")
    private  String postCode;
    @Column(name="specialty")
    private String specialty ;
    @Column(name="location")
    private String location ;
    @ElementCollection
    @Column(name="diplomas")
    private List<String> diplomas;
    @Column(name="place")
    private String place;
    @Column(name="paymentMode")
    private PaymentMode paymentMode;
    @ElementCollection
    @Column(name="languages")
    private List<String> languages;
   @Column(columnDefinition ="TEXT")
    private String  calendar;

}


