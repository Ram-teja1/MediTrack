package com.airtibe.meditrack.service;



import java.util.List;

import com.airtibe.meditrack.entity.Doctor;
import com.airtibe.meditrack.interfaces.Searchable;
import com.airtibe.meditrack.repository.DoctorRepository;

public class DoctorService implements Searchable<Doctor> {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public void registerDoctor(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public Doctor searchById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Doctor> searchByName(String name) {
        return repository.findByName(name);
    }

    public Doctor chooseDoctor(List<Doctor> doctors) {

        if (doctors == null || doctors.isEmpty()) {
            return null;
        }

        return doctors.get(0);
    }
}