package com.microservice.project.moviecatalogservice.models;

public class Ratings {
	
	private String movieId;
	private double ratings;
	
	public Ratings() {
		super();
	}
	public Ratings(String movieId, double ratings) {
		super();
		this.movieId = movieId;
		this.ratings = ratings;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
}
