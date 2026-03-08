package com.airtibe.meditrack.repository;


import java.util.*;

import com.airtibe.meditrack.entity.Doctor;

public class DoctorRepository {

    private final Map<String, Doctor> doctorMap = new HashMap<>();

    public void save(Doctor doctor) {
        doctorMap.put(doctor.getId(), doctor);
    }

    public Doctor findById(String id) {
        return doctorMap.get(id);
    }

    public List<Doctor> findByName(String name) {
        List<Doctor> result = new ArrayList<>();

        for (Doctor d : doctorMap.values()) {
            if (d.getName().equalsIgnoreCase(name)) {
                result.add(d);
            }
        }

        return result;
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctorMap.values());
    }

    public void delete(String id) {
        doctorMap.remove(id);
    }
}
