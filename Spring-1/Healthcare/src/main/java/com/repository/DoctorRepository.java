package com.repository;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepository {
    private Map<String, List<LocalDate>> doctorSchedule = new HashMap<>();

    public DoctorRepository() {
        // Simulated schedule
        doctorSchedule.put("DOC101", Arrays.asList(
                LocalDate.of(2025, 4, 10),
                LocalDate.of(2025, 4, 11)
        ));
        doctorSchedule.put("DOC102", Arrays.asList(
                LocalDate.of(2025, 4, 12)
        ));
    }

    public boolean isDoctorAvailable(String doctorId, LocalDate date) {
        List<LocalDate> availableDates = doctorSchedule.get(doctorId);
        return availableDates != null && availableDates.contains(date);
    }
}
