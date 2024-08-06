package com.company.support.dto.merge;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.request.CreateCommentParamsMerge;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class CommentMerge implements CommentMergeInterface {

  public CreateCommentParamsMerge mergeAddCommentParams(UUID issueId, CreateCommentParamsDto property) {
    return new CreateCommentParamsMerge(
        property.getDescription(),
        issueId,
        property.getClientId(),
        property.getClientName());
  }

}
