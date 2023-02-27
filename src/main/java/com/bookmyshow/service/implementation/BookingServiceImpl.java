package com.bookmyshow.service.implementation;

import com.bookmyshow.domain.BookingDTO;
import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.Show;
import com.bookmyshow.exception.CustomException;
import com.bookmyshow.repository.BookingRepository;
import com.bookmyshow.repository.ShowRepository;
import com.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bookmyshow.mapper.BookingMapper.MAPPER;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowRepository showRepository;

    @Override
    public List<BookingDTO> getAllBookings() {
        return MAPPER.mapEntityListToDTOList(bookingRepository.findAll());
    }


    @Override
    public BookingDTO bookTickets(Long showId, int noOfTickets) {

        Optional<Show> showOptional = showRepository.findById(showId);
        return showOptional.map(show -> {
            Booking booking = null;
            if (show.getAvailability() >= noOfTickets) {
                booking = bookingRepository.save(MAPPER.mapToEntity(show, noOfTickets));
                show.setAvailability(show.getAvailability() - noOfTickets);
                showRepository.save(show);
            }else {
                throw new CustomException("Sorry, All tickets are booked for your slot, you may choose some different slot.Thanks",
                        "Can not book tickets");
            }
            return MAPPER.mapToDTO(booking,noOfTickets);
        }).orElseThrow(() -> new CustomException("No show for the Id","bookTickets"));
    }


}
