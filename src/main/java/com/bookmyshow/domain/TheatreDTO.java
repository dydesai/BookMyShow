package com.bookmyshow.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TheatreDTO {
    private Long theatreId;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private Long cityId;
    @NotNull
    private Integer capacity;
    @NotNull
    private Long movieId;
}

