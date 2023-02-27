package com.bookmyshow.service;

import com.bookmyshow.domain.BookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();

    BookingDTO bookTickets(Long showId, int noOfTickets);
}
