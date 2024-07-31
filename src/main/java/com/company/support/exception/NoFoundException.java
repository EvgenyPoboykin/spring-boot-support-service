package com.company.support.exception;

public class NoFoundException extends RuntimeException {
    private String message;

    public NoFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
