package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

//	/ 🔹 Method-named query: find by location
    List<Theater> findByLocation(String location);

    // 🔹 Custom JPQL query: theaters showing a specific movie
    @Query("SELECT t FROM Theater t JOIN t.movies m WHERE m.id = :movieId")
    List<Theater> findTheatersByMovieId(Long movieId);
}
