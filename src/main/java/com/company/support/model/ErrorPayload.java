package com.company.support.model;

import lombok.Data;

@Data
public class ErrorPayload {
    String description;

    public ErrorPayload(String description){
        this.description = description;
    }
}
