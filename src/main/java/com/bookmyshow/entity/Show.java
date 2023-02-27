package com.bookmyshow.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "show")
public class Show implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @Column(name = "show_time")
    private LocalDateTime showTime;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "price")
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
}
