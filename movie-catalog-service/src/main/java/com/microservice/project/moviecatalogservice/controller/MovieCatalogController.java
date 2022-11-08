package com.microservice.project.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.project.moviecatalogservice.models.CatalogItem;
import com.microservice.project.moviecatalogservice.models.Movie;
import com.microservice.project.moviecatalogservice.models.Ratings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		List<Ratings> ratings = Arrays.asList(
				new Ratings("4", 4.5),
				new Ratings("5", 3)
		);
		
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRatings());
		}).collect(Collectors.toList());
	}
}

/*
 * @Autowired WebClient.Builder builder;
 * 
 * 
 * Movie movie = builder.build() .get() .uri("http://localhost:8082/movies/" +
 * rating.getMovieId()) .retrieve() .bodyToMono(Movie.class) .block();
 */
