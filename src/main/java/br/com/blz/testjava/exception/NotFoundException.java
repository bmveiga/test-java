package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractException{

    public NotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }
}
