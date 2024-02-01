package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExistsException extends AbstractException {

    public ProductAlreadyExistsException(String code, String message) {
        super(code, message, HttpStatus.BAD_REQUEST);
    }
}
