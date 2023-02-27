package com.bookmyshow.controller;

import com.bookmyshow.domain.CityDTO;
import com.bookmyshow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/city")
    public CityDTO addCity(@RequestBody String cityName) {
        return cityService.saveCity(cityName);
    }

}
