package com.airtibe.meditrack.service;



import java.time.LocalDate;
import java.util.List;

import com.airtibe.meditrack.entity.Appointment;
import com.airtibe.meditrack.entity.Doctor;
import com.airtibe.meditrack.entity.Patient;
import com.airtibe.meditrack.enums.AppointmentStatus;
import com.airtibe.meditrack.interfaces.Searchable;
import com.airtibe.meditrack.observer.PatientObserver;
import com.airtibe.meditrack.repository.AppointmentRepository;


public class AppointmentService implements Searchable<Appointment> {

    private final AppointmentRepository repository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public AppointmentService(
            AppointmentRepository repository,
            DoctorService doctorService,
            PatientService patientService) {

        this.repository = repository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public Appointment createAppointment(
            String patientId,
            String doctorId,
            LocalDate date) {

        Patient patient = patientService.searchById(patientId);
        Doctor doctor = doctorService.searchById(doctorId);

        if (patient == null || doctor == null) {
            return null;
        }

        Appointment appointment = new Appointment(patient, doctor, date);

        appointment.addObserver(new PatientObserver(patient));

        repository.save(appointment);

        return appointment;
    }

    public Appointment updateStatus(String appointmentId, AppointmentStatus status) {

        Appointment appointment = repository.findById(appointmentId);

        if (appointment == null) {
            return null;
        }

        appointment.setStatus(status);

        return appointment;
    }

    public Appointment cancelAppointment(String appointmentId) {

        Appointment appointment = repository.findById(appointmentId);

        if (appointment == null) {
            return null;
        }

        appointment.setStatus(AppointmentStatus.APPOINTMENT_CANCELLED);

        return appointment;
    }

    @Override
    public Appointment searchById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Appointment> searchByName(String name) {
        return repository.findAll();
    }

    public Appointment chooseAppointment(List<Appointment> appointments) {

        if (appointments == null || appointments.isEmpty()) {
            return null;
        }

        return appointments.get(0);
    }
}