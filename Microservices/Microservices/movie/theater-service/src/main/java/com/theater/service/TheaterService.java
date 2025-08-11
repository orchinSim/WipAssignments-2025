package com.theater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.model.Theater;
import com.theater.repository.TheaterRepository;



@Service
public class TheaterService {
	@Autowired
	private TheaterRepository theaterRepository;
	
	
	public List<Theater> getAllTheaters()
	{
		return theaterRepository.findAll();
	}
	
	public Theater getTheaterbyId(Long id)
	{
		return theaterRepository.findById(id).orElse(null);
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
            return theaterRepository.save(existing);
		}
		return null;
	}
	
	public void deleteTheater(Long id)
	{
		theaterRepository.deleteById(id);
	}
	
	public List<Theater> getTheatersByLocation(String location) {
        return theaterRepository.findByLocation(location);
    }
	
}