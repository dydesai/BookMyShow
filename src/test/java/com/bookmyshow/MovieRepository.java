package com.bookmyshow;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
class MovieRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testGetAllMovies() {
        Movie movie1 = new Movie();
        movie1.setGenre("Action");
        movie1.setTitle("Avengers");
//        movie1.setReleaseDate(LocalDate.now());
        movie1.setDuration(90);
        movie1.setMovieId(1l);
        Movie movie2 = new Movie();
        movie2.setMovieId(2l);

        entityManager.persist(movie1);
        entityManager.persist(movie2);

        List<Movie> movies = movieRepository.findAll();

        assertThat(movies).hasSize(2).contains(movie1, movie2);

    }
}