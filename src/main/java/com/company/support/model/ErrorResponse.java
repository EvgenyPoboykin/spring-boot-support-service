package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

  private int statusCode;
  private String payload;

  public ErrorResponse(String payload) {
    this.payload = payload;
  }
}
