package com.microservice.project.movieInfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project.movieInfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie(movieId, "TestMovie");
	}
}
