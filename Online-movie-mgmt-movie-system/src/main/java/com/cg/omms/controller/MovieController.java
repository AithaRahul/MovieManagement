package com.cg.omms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omms.entity.Movie;
import com.cg.omms.entity.Theater;
import com.cg.omms.exception.MovieException;
import com.cg.omms.service.MovieService;

@RestController
@CrossOrigin("*")
public class MovieController {
    @Autowired
	MovieService movieService;
 
    @GetMapping("movie")
    public ResponseEntity<List<Movie>> listAllMovie() throws MovieException{
		List<Movie> list = movieService.listAllMovie();
		ResponseEntity<List<Movie>> re = new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
   	      return re;
   	      
    }
   	   @PostMapping("movie")   
   	   public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws MovieException{
   		Movie m = movieService.addMovie(movie);
   		ResponseEntity<Movie> re = new ResponseEntity<Movie>(m,HttpStatus.OK);
      	      return re;
   	 
    }
   	@GetMapping("movie/{id}")
	public ResponseEntity<Movie> findMovieById(@PathVariable("id")int movieId) throws MovieException
	{
		Movie movie = null;
		
		movie = movieService.findMovieById(movieId);
		ResponseEntity<Movie> re = new ResponseEntity(movie,HttpStatus.OK);
		return re;
	}
   	@DeleteMapping("movie/{id}")
	public ResponseEntity<Movie> deleteMovieById(@PathVariable("id") int movieId) throws MovieException
	{		
		Movie m = movieService.deleteMovieById(movieId);
		ResponseEntity<Movie> re = new ResponseEntity(m,HttpStatus.OK);
		return re;
	}
   	@PutMapping("movie")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) throws MovieException
	{
		Movie m = movieService.updateMovie(movie);
		ResponseEntity<Movie> re = new ResponseEntity(m,HttpStatus.OK);
		return re;
	}
   	@GetMapping("movie/theater")
    public ResponseEntity<List<Theater>> listAllTheater() throws MovieException{
		List<Theater> list = movieService.listAllTheater();
		ResponseEntity<List<Theater>> re = new ResponseEntity<List<Theater>>(list,HttpStatus.OK);
   	      return re;
   	}
} 