package com.company.support.exception;

public class NoFoundStageValueException extends RuntimeException {
    private String message;

    public NoFoundStageValueException(String msg) {
        super(msg);
        this.message = msg;
    }
}
