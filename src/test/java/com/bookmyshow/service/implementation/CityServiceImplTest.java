package com.bookmyshow.service.implementation;

import com.bookmyshow.domain.CityDTO;
import com.bookmyshow.entity.City;
import com.bookmyshow.repository.CityRepository;
import com.bookmyshow.service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CityServiceImplTest {

    @Autowired
    CityService cityService;

    @Mock
    CityRepository cityRepository;

    @Test
    void getAllCities() {
        City city = new City();
        city.setCityId(1l);
        city.setCityName("Kolhapur");
        City city1 = new City();
        city1.setCityName("Pune");
        city1.setCityId(2l);
        List<City> cities = new ArrayList<>();
        cities.add(city);
        cities.add(city1);
        Mockito.when(cityRepository.findAll()).thenReturn(cities);

        List<CityDTO> allCities = cityService.getAllCities();

        assertEquals(2,allCities.size());
        assertEquals(1,allCities.get(0).getCityId());
    }

    @Test
    void saveCity() {
        City city = new City();
        city.setCityName("Kolhapur");
        Mockito.when(cityRepository.save(Mockito.any())).thenReturn(city);
        CityDTO cityDTO = cityService.saveCity("Kolhapur");
        assertEquals("Kolhapur",cityDTO.getCityName());
        assertEquals("Kolhapur",cityDTO.getCityId());

    }
}