package com.Sk09Team.Consultation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= " CONSULTATION_DETAILS ")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @Column(name = "patientId")
    private long patientId ;
    @Column(name = "doctorId")
    private long doctorId ;
    @Column(name = "doctorName")
    private String doctorName ;
    @Column(name = "speciality")
    private String speciality ;
    @Column(name = "location")
    private String location ;
    @Column(name = "startAt")
    private String startAt;
    @Column(name = "motif ")
    private String  motif;
    @Column(name = "place")
    private String place ;
    @Column(name = "medical_info")
    private String  medical_info ;






}
