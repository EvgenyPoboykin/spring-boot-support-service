package com.company.support.dto.exception;


public record ErrorResponse(String type, ErrorPayload payload) {

    public static ErrorResponse error(ErrorType type, String message){

        return new ErrorResponse(type.name(), new ErrorPayload(message));

    }

}
