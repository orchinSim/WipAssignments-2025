package com.airline.service;

public class TicketService {
    private FlightService flightService;

    // Setter for XML injection
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public String confirmBooking(String flightId, String userId) {
        if (flightService.isAvailable(flightId)) {
            flightService.bookSeat(flightId);
            return "Booking confirmed for " + userId + " on " + flightId;
        } else {
            return "Flight " + flightId + " is full";
        }
    }
}