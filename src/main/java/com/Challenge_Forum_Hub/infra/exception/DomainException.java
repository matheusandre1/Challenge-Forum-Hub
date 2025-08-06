package com.Challenge_Forum_Hub.infra.exception;

public class DomainException extends RuntimeException {
    public DomainException(){}
    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
