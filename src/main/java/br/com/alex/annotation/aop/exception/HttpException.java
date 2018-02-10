package br.com.alex.annotation.aop.exception;

import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException {

    public HttpException(String message) {
        super(message);
    }

    public abstract SimpleError getError();

    public abstract HttpStatus getStatus();
}

