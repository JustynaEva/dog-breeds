package com.projects.dogbreeds.exception;

import com.projects.dogbreeds.exception.exceptions.BreedNotFoundException;
import org.hibernate.JDBCException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler  {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, ex.getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage()).toList().toString()), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST,
                ex.getMessage().split(":")[0]), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BreedNotFoundException.class)
    public final ResponseEntity<Object> handleBreedNotFoundExceptions(Exception e){

        return new ResponseEntity<>(getBody(HttpStatus.NOT_FOUND,e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public final ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, e.getMessage().split("[':]")[0]),
                HttpStatus.BAD_REQUEST);
    }

    private static Map<String, Object> getBody(HttpStatus status, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status code", status.value());
        body.put("error", status);
        body.put("message", message);
        return body;
    }




}
