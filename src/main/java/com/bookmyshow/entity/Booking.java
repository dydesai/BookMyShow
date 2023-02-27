package com.bookmyshow.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "bookings")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    private Integer noOfTickets;

    @ManyToOne()
    @JoinColumn(name = "show_id")
    private Show show;

    @Column(name = "total_cost")
    private Double totalCost;

}

