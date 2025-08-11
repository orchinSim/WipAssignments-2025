package com.movie.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.exception.ResourceNotFoundException;
import com.movie.model.Booking;
import com.movie.model.Customer;
import com.movie.model.Movie;
import com.movie.model.Theater;
import com.movie.repository.BookingRepository;
import com.movie.repository.CustomerRepository;
import com.movie.repository.MovieRepository;
import com.movie.repository.TheaterRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
    }

    public Booking createBooking(Booking booking) {
            return bookingRepository.save(booking);
        
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existing = getBookingById(id);
        if (existing != null) {
            existing.setBookingDate(updatedBooking.getBookingDate());
            existing.setSeats(updatedBooking.getSeats());
            // Optional: update movie, theater, or customer if needed
            return bookingRepository.save(existing);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
    
    public List<Booking> getBookingsByDate(String date) {
        return bookingRepository.findByBookingDate(date);
    }

    
    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findBookingsByCustomerId(customerId);
    }
    
    
}
