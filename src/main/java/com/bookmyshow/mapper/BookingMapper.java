package com.bookmyshow.mapper;

import com.bookmyshow.domain.BookingDTO;
import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.Show;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BookingMapper {

    BookingMapper MAPPER = Mappers.getMapper( BookingMapper.class );

    @Mapping(source = "show", target = "show")
    @Mapping(source = "noOfTickets", target = "noOfTickets")
    Booking mapToEntity(Show show, int noOfTickets);

    @AfterMapping
    default void calculateTotalPrice(@MappingTarget Booking booking, Show show, int noOfTickets) {
       booking.setBookingTime(LocalDateTime.now());
       booking.setTotalCost(show.getPrice() * noOfTickets);
    }

    @Mapping(source = "booking.bookingId", target = "bookingId")
    @Mapping(source = "booking.show.movie.title", target = "movieName")
    @Mapping(source = "booking.show.theatre.name", target = "theatreName")
    @Mapping(source = "booking.show.showTime", target = "showTime")
    @Mapping(source = "noOfTickets", target = "noOfTickets")
    @Mapping(source = "booking.show.movie.duration", target = "duration")
    @Mapping(source = "booking.show.theatre.city.cityName", target = "city")
    @Mapping(source = "booking.totalCost", target = "totalCost")
    BookingDTO mapToDTO(Booking booking, int noOfTickets);

    BookingDTO mapEntityToDTO(Booking booking);

    List<BookingDTO> mapEntityListToDTOList(List<Booking> all);
}
