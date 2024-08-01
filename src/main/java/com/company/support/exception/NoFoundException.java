package com.company.support.exception;

import com.company.support.model.ErrorType;

public class NoFoundException extends RuntimeException {
    private String message;

    public NoFoundException(String msg) {
        super(msg);
        this.message = msg;

        var type = ErrorType.ID_ISSUE_NOT_FOUND;
    }
}
