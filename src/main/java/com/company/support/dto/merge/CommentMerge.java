package com.company.support.dto.merge;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.request.CreateCommentParamsMergeDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class CommentMerge implements CommentMergeInterface {

  public CreateCommentParamsMergeDto mergeAddCommentParams(UUID issueId, CreateCommentParamsDto property) {
    return new CreateCommentParamsMergeDto(
        property.getDescription(),
        issueId,
        property.getClientId(),
        property.getClientName());
  }

}
