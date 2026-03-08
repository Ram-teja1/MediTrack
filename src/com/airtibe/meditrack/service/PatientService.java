package com.airtibe.meditrack.service;



import java.util.List;

import com.airtibe.meditrack.entity.Patient;
import com.airtibe.meditrack.interfaces.Searchable;
import com.airtibe.meditrack.repository.PatientRepository;


public class PatientService implements Searchable<Patient> {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public void registerPatient(Patient patient) {
        repository.save(patient);
    }

    @Override
    public Patient searchById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Patient> searchByName(String name) {
        return repository.findByName(name);
    }

    public Patient choosePatient(List<Patient> patients) {

        if (patients == null || patients.isEmpty()) {
            return null;
        }

        return patients.get(0);
    }
}