package com.cybercat.user.exception;

import com.cybercat.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(UserNotFoundException e){
       ApiResponse response=ApiResponse.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e){
        ApiResponse response=ApiResponse.builder().message(e.getMessage()).status(HttpStatus.BAD_REQUEST).success(true).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}