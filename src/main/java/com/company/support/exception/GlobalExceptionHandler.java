package com.company.support.exception;

import com.company.support.dto.exception.ErrorResponse;
import com.company.support.dto.exception.ErrorType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

  private <T extends MethodArgumentNotValidException> String mapValidationExceptionToString(T ex) {
    List<String> err = new ArrayList<>();

    ex.getAllErrors().forEach(e -> {
      err.add(e.getDefaultMessage());
    });

    return String.join(" ", err);
  }

  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = InternalServerException.class)
  public @ResponseBody ErrorResponse handleException(InternalServerException ex) {

    return ErrorResponse.error(ErrorType.INTERNAL_SERVER_ERROR, "Server is not response");
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public @ResponseBody ErrorResponse handleException(MethodArgumentNotValidException ex) {

    return ErrorResponse.error(ErrorType.VALIDATION_ERROR, mapValidationExceptionToString(ex));
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = NoFoundException.class)
  public @ResponseBody ErrorResponse handleException(NoFoundException ex) {

    return ErrorResponse.error(ErrorType.ISSUE_NOT_FOUND, ex.getMessage());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = IllegalArgumentException.class)
  public @ResponseBody ErrorResponse handleException(IllegalArgumentException ex) {
    return ErrorResponse.error(ErrorType.ISSUE_NOT_FOUND, ex.getMessage());
  }
}
