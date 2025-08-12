package com.Maccess.patientService.repository;

import com.Maccess.patientService.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
