package com.bookmyshow;

import com.bookmyshow.domain.MovieDTO;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;


/*
        @Test
        public void testGetAllMovies() throws Exception {
            List<Movie> movies = new ArrayList<>();
            movies.add(new Movie(1L, "Avengers: Endgame", "Action", LocalDate.of(2019, 4, 26), 182));
            movies.add(new Movie(2L, "Jurassic World: Fallen Kingdom", "Adventure", LocalDate.of(2018, 6, 22), Duration.ofMinutes(128)));
            Mockito.when(movieService.getAllMovies()).thenReturn(movies);

            mockMvc.perform(get("/movies"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].title", is("Avengers: Endgame")))
                    .andExpect(jsonPath("$[1].title", is("Jurassic World: Fallen Kingdom")));
        }

        @Test
        public void testGetMovieById() throws Exception {
            Long movieId = 1L;
            Movie movie = new Movie(movieId, "Avengers: Endgame", "Action", LocalDate.of(2019, 4, 26), Duration.ofMinutes(182));
            Mockito.when(movieService.getMovieById(movieId)).thenReturn(movie);

            mockMvc.perform(get("/movies/{id}", movieId))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.title", is("Avengers: Endgame")))
                    .andExpect(jsonPath("$.genre", is("Action")))
                    .andExpect(jsonPath("$.releaseDate", is("2019-04-26")))
                    .andExpect(jsonPath("$.duration", is(182)));
        }*/

        @Test
        public void testAddMovie() throws Exception {
            Movie movie = setMovie("Avengers", 182);
            MovieDTO movieDTO= new MovieDTO();
            movieDTO.setDuration(182);
            movieDTO.setGenre("Action");
            movieDTO.setTitle("Avengers");

            Mockito.when(movieService.saveMovie(Mockito.any(MovieDTO.class))).thenReturn(movieDTO);

            String movieJson = "{\"title\":\"Avengers: Endgame\",\"genre\":\"Action\",\"releaseDate\":\"2019-04-26\",\"duration\":182}";

            mockMvc.perform(MockMvcRequestBuilders.post("/bms/api/movies")
                    .content(movieJson))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                    .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$.title", is("Avengers: Endgame")))
                    .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$.genre", is("Action")))
                    .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$.releaseDate", is("2019-04-26")))
                    .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$.duration", is(182)));
        }

    private Movie setMovie(final String title, int duration) {
        Movie movie = new Movie();
        movie.setTitle(title );
        movie.setGenre("Action");
        movie.setDuration(duration);
        return movie;
    }

      /*  @Test
        public void testGetAllTheatres() throws Exception {
            List<Theatre> theatres = new ArrayList<>();
            theatres.add(new Theatre(1L, "PVR Cinemas", "Mumbai", "Maharashtra", "400051"));
            theatres.add(new Theatre(2L, "Cinepolis Cinemas", "Delhi", "Delhi", "110001"));
            Mockito.when(movieService.getAllTheatres()).thenReturn(theatres);

            mockMvc.perform(get("/theatres"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].name", is("PVR Cinemas")))
                    .andExpect(jsonPath("$[1].name", is("");*/

}


   /* @Test
    public void testGetAllMovies() throws Exception {
       mockMvc.perform(get("/movies/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testAddMovie() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Avengers: Endgame");
        movie.setGenre("Action");
//        movie.set
    }*/

