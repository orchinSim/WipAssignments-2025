package com.movie.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity

public class Customer {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

private String email;


@OneToMany(mappedBy = "customer")
@JsonIgnore
private List<Booking> bookings;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public List<Booking> getBookings() {
	return bookings;
}


public void setBookings(List<Booking> bookings) {
	this.bookings = bookings;
}


@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
}


// Getters and Setters

}