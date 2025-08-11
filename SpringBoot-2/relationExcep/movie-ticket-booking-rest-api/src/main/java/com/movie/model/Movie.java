package com.movie.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity

public class Movie {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String title;

private String genre;


@ManyToMany

@JoinTable(

name = "movie_theater",

joinColumns = @JoinColumn(name = "movie_id"),

inverseJoinColumns = @JoinColumn(name = "theater_id"))

private List<Theater> theaters;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getGenre() {
	return genre;
}


public void setGenre(String genre) {
	this.genre = genre;
}


public List<Theater> getTheaters() {
	return theaters;
}


public void setTheaters(List<Theater> theaters) {
	this.theaters = theaters;
}


@Override
public String toString() {
	return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", theaters=" + theaters + "]";
}


// Getters and Setters


}