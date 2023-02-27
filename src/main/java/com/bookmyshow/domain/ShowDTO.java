package com.bookmyshow.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ShowDTO {
    @NotNull
    private Long theatreId;
    @NotNull
    private Long movieId;
    private Long showId;
    @NotNull
    private LocalDateTime showTime;
    @NotNull
    private Integer availability;
}

