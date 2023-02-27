package com.bookmyshow.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "theatre")
public class Theatre implements Serializable {
    @Id
    @Column(name = "theatre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;


}

