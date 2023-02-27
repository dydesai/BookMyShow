package com.bookmyshow.mapper;

import com.bookmyshow.domain.CityDTO;
import com.bookmyshow.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper MAPPER = Mappers.getMapper( CityMapper.class );

        CityDTO mapEntityToDTO(City city);

        @Mapping(source = "cityName", target="cityName")
        City mapDTOtoEntity(String cityName);

        List<CityDTO> mapEntityToDTO(List<City> city);
}
