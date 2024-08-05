package com.company.support.dto.validations;

import com.company.support.dto.request.CreateCommentParamsDto;

import java.util.UUID;

public interface CommentValidationInterface {

  void validationAddCommentParams(UUID issueId, CreateCommentParamsDto property);

}
