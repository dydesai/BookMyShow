package com.bookmyshow.service;

import com.bookmyshow.domain.TheatreDTO;
import com.bookmyshow.entity.Theatre;

import java.util.List;

public interface TheatreService {
    List<Theatre> getTheatreByMovie(Long movieId);

    List<Theatre> getAllTheatres();

    Long addTheatre(TheatreDTO theatreDTO);
}
