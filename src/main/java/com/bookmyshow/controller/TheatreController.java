package com.bookmyshow.controller;

import com.bookmyshow.domain.TheatreDTO;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @PostMapping("/theatres")
    public Long addTheatre(@RequestBody TheatreDTO theatre)
    {
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("/theatre/{movie_id}")
    public List<Theatre> getTheatresByMovie(@PathVariable("movie_id") Long movieId) {
       return theatreService.getTheatreByMovie(movieId);
    }
}
