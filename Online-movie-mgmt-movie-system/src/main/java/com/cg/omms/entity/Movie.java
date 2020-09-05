package com.cg.omms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 

@Table(name="movie_tbl")
public class Movie {
    
    @Id
	@GeneratedValue(generator = "mygen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="onlinemovie_movie_seq",allocationSize=1)
    @Column(name="movie_id")
    private int movieId;
    @Column(name="movie_name", length=15)
    private String movieName;
    @Column(name="language", length=15)
    private String language;
    @Column(name="director", length=15)
    private String director;
    @Column(name="genre", length=15)
    private String genre;
    @Column(name="movie_length")
    private int movieLength;
    
    @ManyToOne
    @JoinColumn(name="theater_id", referencedColumnName = "theater_id")
    private Theater theater = new Theater();
    @JsonIgnore
	 @OneToMany(mappedBy = "movie")
	private List<Show> listOfshows = new ArrayList<Show>();
    
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getMovieLength() {
        return movieLength;
    }
 
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}
	public List<Show> getListOfshows() {
		return listOfshows;
	}
	public void setListOfshows(List<Show> listOfshows) {
		this.listOfshows = listOfshows;
	}  
    
}