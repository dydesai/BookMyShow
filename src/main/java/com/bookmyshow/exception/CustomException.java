package com.bookmyshow.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private final String apiSource;

    public CustomException(String message, Throwable cause, String apiSource) {
        super(message, cause);
        this.apiSource = apiSource;
    }
    public CustomException(String message,String apiSource) {
        super(message);
        this.apiSource = apiSource;
    }
}
