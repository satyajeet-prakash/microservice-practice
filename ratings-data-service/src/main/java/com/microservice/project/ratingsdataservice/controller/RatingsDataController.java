package com.microservice.project.ratingsdataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project.ratingsdataservice.models.Ratings;

@RestController
@RequestMapping("/ratings")
public class RatingsDataController {
	
	@RequestMapping("/{movieId}")
	public Ratings getRatings(@PathVariable String movieId) {
		return new Ratings(movieId, 4.5);
	}
}
