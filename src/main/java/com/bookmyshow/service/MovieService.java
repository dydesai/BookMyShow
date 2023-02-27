package com.bookmyshow.service;

import com.bookmyshow.domain.MovieDTO;
import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO saveMovie(MovieDTO movieDTO);

    List<Movie> getMoviesByCity(Long cityId);
}
