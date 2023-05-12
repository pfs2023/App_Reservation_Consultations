package com.Sk09Team.Consultation.repository;

import com.Sk09Team.Consultation.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
