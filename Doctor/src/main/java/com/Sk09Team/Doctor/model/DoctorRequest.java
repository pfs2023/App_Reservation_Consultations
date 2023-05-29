package com.Sk09Team.Doctor.model;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String city ;
    private  String specialty ;
    private String postCode;
    private  String address  ;
   private String password ;



}
