package com.bookmyshow.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MovieDTO {

    private Long movieId;

    @NotNull
    @NotEmpty
    private String title;

    private String genre;

    private Integer duration;
}

