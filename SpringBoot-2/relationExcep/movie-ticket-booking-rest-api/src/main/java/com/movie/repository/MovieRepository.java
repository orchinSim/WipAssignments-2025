package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	// 🔹 Method-named query: find by genre
    List<Movie> findByGenre(String genre);

    // 🔹 Method-named query: find by title containing keyword (case-insensitive)
    List<Movie> findByTitleContainingIgnoreCase(String keyword);

    // 🔹 Custom JPQL query: get movies with a specific number of characters in title
    @Query("SELECT m FROM Movie m WHERE LENGTH(m.title) = ?1")
    List<Movie> findMoviesWithTitleLength(int length);
}