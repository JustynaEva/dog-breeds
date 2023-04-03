package com.projects.dogbreeds.exception;

import com.projects.dogbreeds.exception.exceptions.BreedNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(BreedNotFoundException.class)
    public final ResponseEntity<Object> handleEntityNotFoundExceptions(Exception e){

        return new ResponseEntity<>(getBody(HttpStatus.NOT_FOUND,e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<Object> handleMessageNotReadableExceptions(Exception e){
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST,
                Arrays.stream(e.getMessage().split(":")).findFirst().get()), HttpStatus.BAD_REQUEST);
    }

    private static Map<String, Object> getBody(HttpStatus status, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("message", message);
        return body;
    }
}
