package com.bookmyshow.service.implementation;

import com.bookmyshow.domain.CityDTO;
import com.bookmyshow.entity.City;
import com.bookmyshow.repository.CityRepository;
import com.bookmyshow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bookmyshow.mapper.CityMapper.MAPPER;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDTO> getAllCities() {
        return MAPPER.mapEntityToDTO(cityRepository.findAll());
    }

    @Override
    public CityDTO saveCity(String cityName) {
        City city = MAPPER.mapDTOtoEntity(cityName);
        return MAPPER.mapEntityToDTO(cityRepository.save(city));
    }
}

