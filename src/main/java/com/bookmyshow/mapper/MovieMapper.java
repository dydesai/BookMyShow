package com.bookmyshow.mapper;

import com.bookmyshow.domain.MovieDTO;
import com.bookmyshow.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieMapper {

    MovieMapper MAPPER = Mappers.getMapper( MovieMapper.class );

        MovieDTO mapEntityToDTO(Movie movie);

        Movie mapDTOtoEntity(MovieDTO movieDTO);

        List<MovieDTO> mapEntityToDTO(List<Movie> movie);
}
