package com.bookmyshow.repository;

import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findAllByTheatre(Theatre theatre);
}
