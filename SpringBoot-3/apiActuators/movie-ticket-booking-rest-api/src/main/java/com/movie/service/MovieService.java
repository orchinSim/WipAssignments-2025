package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.exception.ResourceNotFoundException;
import com.movie.model.Movie;
import com.movie.model.Theater;
import com.movie.repository.MovieRepository;
import com.movie.repository.TheaterRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private TheaterRepository theaterRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));
    }
    
    //create Movie-for posting
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie existing = getMovieById(id);
        if (existing != null) {
            existing.setTitle(movie.getTitle());
            existing.setGenre(movie.getGenre());
            existing.setTheaters(movie.getTheaters());
            return movieRepository.save(existing);
        }
        return null;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    
//    public Movie addTheatersToMovie(Long movieId, List<Long> theaterIds) {
//        Movie movie = movieRepository.findById(movieId).get(); // no exception handling
//        List<Theater> theaters = theaterRepository.findAllById(theaterIds);
//        movie.setTheaters(theaters);
//        return movieRepository.save(movie);
//    }
    
    
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    
    public List<Movie> searchMoviesByTitle(String keyword) {
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }

    
    public List<Movie> getMoviesWithTitleLength(int length) {
        return movieRepository.findMoviesWithTitleLength(length);
    }
    
}