package com.cg.omms.dao;

import java.util.List;

import com.cg.omms.entity.Movie;
import com.cg.omms.entity.Theater;
import com.cg.omms.exception.MovieException;

public interface MovieDao {
	
	public List<Movie> listAllMovie() throws MovieException;
	
	public Movie addMovie(Movie movie) throws MovieException;
	public Movie findMovieById(int movieId) throws MovieException;
	public Movie deleteMovieById(int movieId) throws MovieException;
	public Movie updateMovie(Movie movie) throws MovieException;
	public List<Theater> listAllTheater() throws MovieException;
}
