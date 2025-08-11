package com.theater.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theater.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

//	/ 🔹 Method-named query: find by location
    List<Theater> findByLocation(String location);

}
