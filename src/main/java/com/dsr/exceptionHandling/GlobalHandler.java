package com.dsr.exceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {
//The idea with the ErrorDetails is to push/return an object that has all details of error


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> preconditon(HttpClientErrorException.BadRequest badRequest){
        System.out.println("INSIDE OF IllegalArgumentException");
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.PRECONDITION_FAILED.value(),HttpStatus.PRECONDITION_FAILED.name(),badRequest.getLocalizedMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.PRECONDITION_FAILED);
    }


//    COPIED - The below handler, given ResponseEntityExceptionHandler has MethodArgumentNotValidException you cannot define another handler for it, instead have to override from ResponseEntityExceptionHandler to customize
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(),ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ErrorDetails> badRequestException(HttpClientErrorException.BadRequest badRequest){
        System.out.println("INSIDE OF HttpClientErrorException");
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(),badRequest.getLocalizedMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    //TODO perhaps investigate using @ExceptionHandler(HttpClientErrorException.NotFound.class)

    @ExceptionHandler(DataNotFound.class)
    public ResponseEntity<ErrorDetails> dataNotFoundException(DataNotFound notFound){
        System.out.println("INSIDE *********** DNF");
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),notFound.getLocalizedMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> mainException(Exception badRequest){
        System.out.println("INSIDE OF Exception");

        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name(),badRequest.getLocalizedMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
