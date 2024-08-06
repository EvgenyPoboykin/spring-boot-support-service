package com.company.support.exception;

import com.company.support.dto.exception.ErrorResponse;
import com.company.support.dto.exception.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = InternalServerException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public @ResponseBody ErrorResponse handleInternalServerException(InternalServerException ex) {
    return ErrorResponse.error(ErrorType.INTERNAL_SERVER_ERROR, ex.getMessage());
  }

  @ExceptionHandler(value = DataAccessException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public @ResponseBody ErrorResponse handle(DataAccessException ex) {
    return ErrorResponse.error(ErrorType.BAR_REQUEST, ex.getMessage());
  }

  @ExceptionHandler(value = NoFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ErrorResponse handleNoFoundException(NoFoundException ex) {
    return ErrorResponse.error(ErrorType.ISSUE_NOT_FOUND, ex.getMessage());
  }
}
