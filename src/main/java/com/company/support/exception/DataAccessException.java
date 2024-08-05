package com.company.support.exception;

public class DataAccessException extends RuntimeException {
  private String message;

  public DataAccessException(String msg) {
    super(msg);
    this.message = msg;

  }
}
