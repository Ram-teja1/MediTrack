package com.airtibe.meditrack.observer;

import com.airtibe.meditrack.entity.Appointment;

public interface AppointmentObserver {
    void update(Appointment appointment);
}
