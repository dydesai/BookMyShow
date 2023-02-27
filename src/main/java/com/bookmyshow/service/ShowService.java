package com.bookmyshow.service;

import com.bookmyshow.domain.ShowDTO;
import com.bookmyshow.entity.Show;

import java.util.List;

public interface ShowService {
    List<Show> getAllShows();

    Long addShow(ShowDTO showDTO);

    List<Show> getShowsByTheatreId(Long theatreId);
}
