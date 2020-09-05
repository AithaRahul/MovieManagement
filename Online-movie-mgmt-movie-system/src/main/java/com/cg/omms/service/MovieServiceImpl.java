package com.cg.omms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omms.dao.MovieDao;
import com.cg.omms.entity.Movie;
import com.cg.omms.entity.Theater;
import com.cg.omms.exception.MovieException;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	@Override
	public List<Movie> listAllMovie() throws MovieException {
		
		List<Movie> list = movieDao.listAllMovie();
		return list;
	}

	@Override
	public Movie addMovie(Movie movie) throws MovieException {
	    movieDao.addMovie(movie);
		return movie;
	}
	@Override
	public Movie findMovieById(int movieId) throws MovieException {
         
		Movie movie = movieDao.findMovieById(movieId);
		
		if(movie == null)
		{
			throw new MovieException(movieId+" ID Not Found");
		}
		return movie;
		
	}

	@Override
	public Movie deleteMovieById(int movieId) throws MovieException {
         
		Movie movie = movieDao.deleteMovieById(movieId);
		
		if(movie == null)
		{
			throw new MovieException(movieId+" ID Not Found");	
		}
		return movie;
	}
	
	@Override
	public Movie updateMovie(Movie movie) throws MovieException {
		if(movieDao.findMovieById(movie.getMovieId())!=null)
		{
			 movieDao.updateMovie(movie); //remove return
		}
		else
			{
			throw new MovieException(movie.getMovieId()+"ID Not Found");
			}
		return movie;
	}

	@Override
	public List<Theater> listAllTheater() throws MovieException {
		List<Theater> list = movieDao.listAllTheater();
		return list;
	}

	

}