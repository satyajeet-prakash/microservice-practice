package com.microservice.project.moviecatalogservice.models;

public class CatalogItem {
	
	private String movie;
	private String desc;
	private double rating;
	
	public CatalogItem() {
		super();
	}
	public CatalogItem(String movie, String desc, double rating) {
		super();
		this.movie = movie;
		this.desc = desc;
		this.rating = rating;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
