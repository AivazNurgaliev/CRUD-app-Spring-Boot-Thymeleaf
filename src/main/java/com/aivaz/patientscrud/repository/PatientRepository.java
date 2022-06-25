package com.aivaz.patientscrud.repository;

import com.aivaz.patientscrud.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
