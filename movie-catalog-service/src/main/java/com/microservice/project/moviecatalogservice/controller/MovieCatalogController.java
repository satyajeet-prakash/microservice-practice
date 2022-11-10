package com.microservice.project.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.project.moviecatalogservice.models.CatalogItem;
import com.microservice.project.moviecatalogservice.models.Movie;
import com.microservice.project.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + 
		userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			
			
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRatings());
		}).collect(Collectors.toList());
	}
}

/*
 * Advance Load Balancing - explore DiscoveryClient
 * 
 * @Autowired
 * DiscoveryClient discoveryClient;
 * 
 */

/*
 * @Autowired WebClient.Builder builder;
 * 
 * 
 * Movie movie = builder.build() .get() .uri("http://localhost:8082/movies/" +
 * rating.getMovieId()) .retrieve() .bodyToMono(Movie.class) .block();
 */
