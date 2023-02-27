package com.bookmyshow.service.implementation;

import com.bookmyshow.domain.MovieDTO;
import com.bookmyshow.entity.City;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.exception.CustomException;
import com.bookmyshow.repository.*;
import com.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bookmyshow.mapper.MovieMapper.MAPPER;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<MovieDTO> getAllMovies() {
        return MAPPER.mapEntityToDTO(movieRepository.findAll());
    }

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = MAPPER.mapDTOtoEntity(movieDTO);
        return MAPPER.mapEntityToDTO(movieRepository.save(movie));
    }



    @Override
    public List<Movie> getMoviesByCity(Long cityId) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        /*return theatreRepository.findAllByCity(city.get())
                .stream()
                .map(Theatre::getMovie)
                .collect(Collectors.toList());*/
       return cityOptional.map(city -> {
           return theatreRepository.findAllByCity(city)
                   .stream()
                   .map(Theatre::getMovie)
                   .collect(Collectors.toList());
       }).orElseThrow(() -> new CustomException("No movies found for the city ","getMoviesByCity"));
    }
}


