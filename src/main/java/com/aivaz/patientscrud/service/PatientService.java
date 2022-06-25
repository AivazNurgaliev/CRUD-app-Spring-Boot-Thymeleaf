package com.aivaz.patientscrud.service;

import com.aivaz.patientscrud.model.Patient;
import com.aivaz.patientscrud.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientRepository patientRepository1) {
        this.patientRepository = patientRepository1;
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
