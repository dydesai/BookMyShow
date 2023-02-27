package com.bookmyshow.service.implementation;

import com.bookmyshow.domain.TheatreDTO;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.exception.CustomException;
import com.bookmyshow.mapper.TheatreMapper;
import com.bookmyshow.repository.MovieRepository;
import com.bookmyshow.repository.TheatreRepository;
import com.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Theatre> getTheatreByMovie(Long movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        return movieOptional.map(movie -> theatreRepository.findAllByMovie(movie))
                .orElseThrow(() -> new CustomException("No movie found by id","getTheatreByMovie"));
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public Long addTheatre(TheatreDTO theatreDTO) {
        Theatre theatre = theatreRepository.save(TheatreMapper.MAPPER.mapDTOToEntity(theatreDTO));
        return theatre.getTheatreId();

    }
}
