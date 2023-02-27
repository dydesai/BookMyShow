package com.bookmyshow.controller;

import com.bookmyshow.domain.BookingDTO;
import com.bookmyshow.entity.Booking;
import com.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book/{showId}")
    public BookingDTO bookTickets(@PathVariable @Valid @NotNull Long showId,
                                  @RequestParam @Valid @NotNull @Positive int noOfTickets) {
        return bookingService.bookTickets(showId, noOfTickets);
    }

    @GetMapping("/bookings")
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

}
