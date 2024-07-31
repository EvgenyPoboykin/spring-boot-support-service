package com.company.support.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String payload;

    public ErrorResponse(String payload)
    {
        super();
        this.payload = payload;
    }
}