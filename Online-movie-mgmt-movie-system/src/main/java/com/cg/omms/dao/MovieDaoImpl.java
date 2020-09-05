package com.cg.omms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.omms.entity.Movie;
import com.cg.omms.entity.Theater;
import com.cg.omms.exception.MovieException;



@Repository
@Transactional
public class MovieDaoImpl implements MovieDao{
	@Autowired
	EntityManager entityManager;


	@Override
	public List<Movie> listAllMovie() throws MovieException{
		String qry = "SELECT m FROM Movie m";
		TypedQuery<Movie> query = entityManager.createQuery(qry,Movie.class);
	    List<Movie> list = query.getResultList();
	    return list;	}


	@Override
	public Movie addMovie(Movie movie) throws MovieException {
		entityManager.persist(movie);
		
		return movie;
	}

	@Override
	public Movie findMovieById(int movieId) throws MovieException {
		Movie movie = entityManager.find(Movie.class, movieId);
		return movie;
	}


	@Override
	public Movie deleteMovieById(int movieId) throws MovieException {
		Movie movie = entityManager.find(Movie.class, movieId);
		if(movie != null)
		{
			entityManager.remove(movie);
		}
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieException {
		 entityManager.merge(movie);
		return movie;
	}


	@Override
	public List<Theater> listAllTheater() throws MovieException {
		String qry = "SELECT m FROM Theater m";
		TypedQuery<Theater> query = entityManager.createQuery(qry,Theater.class);
		List<Theater> list = query.getResultList();
		return list;
		
		}
	}




