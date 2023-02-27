package com.bookmyshow.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CityDTO {
    @NotNull
    @NotEmpty
    private String cityName;
    private Long cityId;
}

