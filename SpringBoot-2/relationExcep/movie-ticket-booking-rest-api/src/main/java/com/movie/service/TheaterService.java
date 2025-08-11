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
public class TheaterService {
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private MovieRepository  movieRepository;
	
	public List<Theater> getAllTheaters()
	{
		return theaterRepository.findAll();
	}
	
	public Theater getTheaterbyId(Long id)
	{
		return theaterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theater not found with ID: " + id));
	}
	
	public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }
	
	public Theater updateTheater(Long id,Theater updatedTheater)
	{
		Theater existing = getTheaterbyId(id);
		if(existing!=null)
		{
			existing.setName(updatedTheater.getName());
			existing.setLocation(updatedTheater.getLocation());
            existing.setMovies(updatedTheater.getMovies());
            return theaterRepository.save(existing);
		}
		return null;
	}
	
	public void deleteTheater(Long id)
	{
		theaterRepository.deleteById(id);
	}
	
//	public void addMovieToTheater(Long theaterId, Long movieId) {
//        Theater theater = theaterRepository.findById(theaterId).orElse(null);
//        Movie movie = movieRepository.findById(movieId).orElse(null);
//        
//        if (theater != null && movie != null) {
//            theater.getMovies().add(movie);
//            theaterRepository.save(theater);
//        }
//    }
	
	
	public List<Theater> getTheatersByLocation(String location) {
        return theaterRepository.findByLocation(location);
    }
	
    public List<Theater> getTheatersByMovieId(Long movieId) {
        return theaterRepository.findTheatersByMovieId(movieId);
    }
}