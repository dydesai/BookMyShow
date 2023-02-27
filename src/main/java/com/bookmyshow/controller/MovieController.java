package com.bookmyshow.controller;

import com.bookmyshow.domain.MovieDTO;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@Validated
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/movies")
    public MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.saveMovie(movieDTO);
    }

    @GetMapping("/movies/{cityId}")
    public List<Movie> getMoviesByCity (@PathVariable Long cityId){
        return movieService.getMoviesByCity(cityId);
    }
}


