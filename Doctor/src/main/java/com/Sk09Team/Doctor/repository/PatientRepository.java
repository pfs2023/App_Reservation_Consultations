package com.Sk09Team.Doctor.repository;

import com.Sk09Team.Doctor.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String > {
}
