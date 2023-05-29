package com.Sk09Team.Doctor.repository;

import com.Sk09Team.Doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findByCity(String city);
    List<Doctor> findBySpecialty(String specialty); // Update the method name to match the field name
    List<Doctor> findByCityAndSpecialty(String city, String specialty);
    

}
