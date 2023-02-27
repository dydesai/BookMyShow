package com.bookmyshow.mapper;

import com.bookmyshow.domain.TheatreDTO;
import com.bookmyshow.entity.Theatre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
    public interface TheatreMapper {

        TheatreMapper MAPPER = Mappers.getMapper( TheatreMapper.class );

        @Mapping(source="cityId",target="city.cityId")
        @Mapping(source="movieId",target="movie.movieId")
        Theatre mapDTOToEntity(TheatreDTO theatre);
    }
