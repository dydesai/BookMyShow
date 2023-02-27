package com.bookmyshow.domain;

import lombok.Data;

@Data
public class BookingDTO {

    private Long bookingId;
    private String movieName;
    private String theatreName;
    private String showTime;
    private Integer noOfTickets;
    private String duration;
    private String city;
    private Double totalCost;
}
