package com.simplecrud.exception;


import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exception class for mandatory data in error response
 *
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException{

    private String message;
    private String description;
    @JsonIgnore
    private HttpStatus status;
    private int code;
}
