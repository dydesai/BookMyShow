package com.bookmyshow.mapper;

import com.bookmyshow.domain.ShowDTO;
import com.bookmyshow.domain.TheatreDTO;
import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.Theatre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
    public interface ShowMapper {

        ShowMapper MAPPER = Mappers.getMapper( ShowMapper.class );

        @Mapping(source="theatreId",target="theatre.theatreId")
        @Mapping(source="movieId",target="movie.movieId")
        Show mapDTOToEntity(ShowDTO showDTO);
    }
