package br.com.blz.testjava.exception;

import br.com.blz.testjava.util.MessageExceptionFormatter;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbstractException extends RuntimeException {

    private final String code;
    private final HttpStatus httpStatus;

    public AbstractException(String code, String message, HttpStatus httpStatus) {
        super(MessageExceptionFormatter.getErrorMessage(code, message));
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
