package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Theater;
import com.movie.service.TheaterService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {
	@Autowired
    private TheaterService theaterService;
	
	@GetMapping
	public List<Theater> getAllTheaters(){
		return theaterService.getAllTheaters();
	}
	
	@GetMapping("/{id}")
	public Theater getTheaterById(@PathVariable Long id)
	{
		return theaterService.getTheaterbyId(id);
	}
	
	@PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.saveTheater(theater);
    }
	
	@PutMapping("/{id}")
    public Theater updateTheater(@PathVariable Long id, @RequestBody Theater theater) {
        return theaterService.updateTheater(id, theater);
    }
	
	@DeleteMapping("/{id}")
    public void deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
    }
	
	
//	@PostMapping("/{theaterId}/movies/{movieId}")
//    public String addMovieToTheater(@PathVariable Long theaterId, @PathVariable Long movieId) {
//        theaterService.addMovieToTheater(theaterId, movieId);
//        return "Movie linked to theater successfully!";
//    }
	
	@GetMapping("/location/{location}")
    public List<Theater> getTheatersByLocation(@PathVariable String location) {
        return theaterService.getTheatersByLocation(location);
    }

    @GetMapping("/movie/{movieId}")
    public List<Theater> getTheatersByMovie(@PathVariable Long movieId) {
        return theaterService.getTheatersByMovieId(movieId);
    }
}
