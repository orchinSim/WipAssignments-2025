package com.movie.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity

public class Theater {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

private String location;


@ManyToMany(mappedBy = "theaters")
//@JsonIgnoreProperties("movies")
@JsonIgnore
private List<Movie> movies;



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


public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}


public List<Movie> getMovies() {
	return movies;
}


public void setMovies(List<Movie> movies) {
	this.movies = movies;
}


@Override
public String toString() {
	return "Theater [id=" + id + ", name=" + name + ", location=" + location + ", movies=" + movies + "]";
}

// Getters and Setters


}