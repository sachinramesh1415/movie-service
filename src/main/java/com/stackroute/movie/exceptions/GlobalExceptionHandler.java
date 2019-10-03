package com.stackroute.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> handleMovieNotFoundException() {
        return new ResponseEntity<String>("Movie has not been found", HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> handleMovieAlreadyExistsException() {
        return new ResponseEntity<String>("Movie already exists",HttpStatus.CONFLICT);
    }
}
