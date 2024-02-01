package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(AbstractException.class)
    public ResponseEntity<Object> handlerAbstractException(AbstractException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getCode(), e.getMessage()), e.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ExceptionResponse("1", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ExceptionResponse("2", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
