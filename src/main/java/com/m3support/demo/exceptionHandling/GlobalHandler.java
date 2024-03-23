package com.m3support.demo.exceptionHandling;

import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {
//The idea with the ErrorDetails is to push/return an object that has all details of error


    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<ErrorDetails> preconditon(HttpClientErrorException.BadRequest badRequest){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.PRECONDITION_FAILED.value(),HttpStatus.PRECONDITION_FAILED.name(),badRequest.getLocalizedMessage(), Arrays.toString(badRequest.getStackTrace()));
        return new ResponseEntity<>(errorDetails, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    ResponseEntity<ErrorDetails> dataNotFoundException(HttpClientErrorException.BadRequest badRequest){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(),badRequest.getLocalizedMessage(), Arrays.toString(badRequest.getStackTrace()));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorDetails> mainException(Exception badRequest){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name(),badRequest.getLocalizedMessage(), Arrays.toString(badRequest.getStackTrace()));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
