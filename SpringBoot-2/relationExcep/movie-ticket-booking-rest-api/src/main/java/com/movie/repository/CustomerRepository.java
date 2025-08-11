package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	 // 🔹 Method-named query: find by email
    Customer findByEmail(String email);
}
