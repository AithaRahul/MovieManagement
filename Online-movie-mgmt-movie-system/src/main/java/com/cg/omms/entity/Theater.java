package com.cg.omms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="movie_theater_tbl")
public class Theater {
	@Id
	@GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="onlinemovie_theater_seq",allocationSize=1)
	@Column(name="theater_id")
	private int theaterId;
	 @Column(name="theater_name", length=15)
	private String theaterName;
	 @Column(name="theater_city", length=15)
	private String theaterCity;
	 @Column(name="manager_name", length=15)
	private String managerName;
	 @Column(name="manager_contact" ,length=10)
	private String managerContact;
	 @JsonIgnore
	 @OneToMany(mappedBy = "theater")
	private List<Movie> listOfMovies = new ArrayList<Movie>();
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	public List<Movie> getListOfMovies() {
		return listOfMovies;
	}
	public void setListOfMovies(List<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}
	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Theater(int theaterId, String theaterName, String theaterCity, String managerName, String managerContact,
			List<Movie> listOfMovies) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.listOfMovies = listOfMovies;
	}
	
	
	
}