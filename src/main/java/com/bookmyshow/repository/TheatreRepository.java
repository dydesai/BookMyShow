package com.bookmyshow.repository;

import com.bookmyshow.entity.City;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findAllByCity(City city);

    List<Theatre> findAllByMovie(Movie movie);
}
