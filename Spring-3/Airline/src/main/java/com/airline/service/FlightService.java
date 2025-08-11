package com.airline.service;

import java.util.HashMap;
import java.util.Map;

public class FlightService {
    private Map<String, Integer> flightSeats = new HashMap<>();

    public FlightService() {
        // Simulated seat availability
        flightSeats.put("FL123", 2);
        flightSeats.put("FL456", 0); // full
    }

    public boolean isAvailable(String flightId) {
        Integer seats = flightSeats.get(flightId);
        return seats != null && seats > 0;
    }

    public void bookSeat(String flightId) {
        flightSeats.put(flightId, flightSeats.get(flightId) - 1);
    }
}