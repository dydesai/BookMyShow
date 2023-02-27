package com.bookmyshow.controller;

import com.bookmyshow.domain.ShowDTO;
import com.bookmyshow.entity.Show;
import com.bookmyshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/shows")
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @PostMapping("/shows")
    public Long addShow(@RequestBody ShowDTO showDTO) {
        return showService.addShow(showDTO);
    }

    @GetMapping("/show/{theatreId}")
    public List<Show> getShowsByTheatre(@PathVariable Long theatreId) {
        return showService.getShowsByTheatreId(theatreId);
    }
}
