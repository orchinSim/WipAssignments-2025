package com.movie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	// 🔹 Method-named query: find by booking date
	List<Booking> findByBookingDate(String bookingDate);


    @Query("SELECT b FROM Booking b WHERE b.customer.id = :customerId")
    List<Booking> findBookingsByCustomerId(@Param("customerId") Long customerId);

}