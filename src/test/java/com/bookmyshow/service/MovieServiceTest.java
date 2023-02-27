package com.bookmyshow.service;

import com.bookmyshow.domain.MovieDTO;
import com.bookmyshow.entity.City;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.repository.TheatreRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Mock
    TheatreRepository theatreRepository;

    @Test
    public void testSaveMovie() {
        MovieDTO movie = setMovieDTO();

        MovieDTO addedMovie = movieService.saveMovie(movie);
        assertNotNull(addedMovie.getMovieId());
        assertEquals(movie.getTitle(), addedMovie.getTitle());
        assertEquals(movie.getGenre(), addedMovie.getGenre());
        assertEquals(movie.getDuration(), addedMovie.getDuration());
    }

    private MovieDTO setMovieDTO() {
        MovieDTO movie = new MovieDTO();
        movie.setTitle("Avengers: Endgame");
        movie.setGenre("Action");
        movie.setMovieId(1l);
        movie.setDuration(182);
        return movie;
    }

    @Test
    public void testGetAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        assertNotNull(movies);
        assertTrue(movies.size() > 0);
    }

    @Test
    public void getAllMoviesbyCityId() {
        City city = new City();
        city.setCityId(1l);
        city.setCityName("Kolhapur");
        Movie movie = new Movie();
        movie.setTitle("Avengers: Endgame");
        movie.setGenre("Action");
        movie.setMovieId(1l);
        movie.setDuration(182);
        Theatre theatre = new Theatre();
        theatre.setCity(city);
        theatre.setTheatreId(1l);
        theatre.setMovie(movie);
        List<Theatre> theatres = new ArrayList<>();
        theatres.add(theatre);

        Mockito.when(theatreRepository.findAllByCity(city)).thenReturn(theatres);

        List<Movie> moviesByCity = movieService.getMoviesByCity(1l);
        assertEquals(moviesByCity.get(0).getMovieId(), theatre.getMovie().getMovieId());
    }

}

