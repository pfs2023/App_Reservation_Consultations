package com.Sk09Team.Doctor.repository;

import com.Sk09Team.Doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Doctor,Long> {
}
