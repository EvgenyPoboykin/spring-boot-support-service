package com.company.support.dto.validations;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.exception.NoFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentValidation implements CommentValidationInterface {

  public void validationAddCommentParams(UUID issueId, CreateCommentParamsDto property) {
    if (issueId == null) {
      throw new NoFoundException("issueId is required field!");
    }

    if (property.getDescription().isEmpty() | property.getDescription() == null) {
      throw new NoFoundException("description is required field!");
    }

    if (property.getClientId() == null) {
      throw new NoFoundException("clientId is required field!");
    }

    if (property.getClientName().isEmpty() | property.getClientName() == null) {
      throw new NoFoundException("clientName is required field!");
    }

  }

}
