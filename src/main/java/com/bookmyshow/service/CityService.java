package com.bookmyshow.service;

import com.bookmyshow.domain.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> getAllCities();

    CityDTO saveCity(String cityName);
}
