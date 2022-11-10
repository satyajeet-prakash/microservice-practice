package com.microservice.project.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project.ratingsdataservice.models.Ratings;
import com.microservice.project.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsDataController {
	
	@RequestMapping("/{movieId}")
	public Ratings getRatings(@PathVariable String movieId) {
		return new Ratings(movieId, 4.5);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getRating(@PathVariable String userId) {
		List<Ratings> ratings = Arrays.asList(
				new Ratings("4", 4.5),
				new Ratings("5", 3.5));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
