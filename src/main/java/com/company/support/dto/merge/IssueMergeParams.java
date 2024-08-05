package com.company.support.dto.merge;

import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsMergeDto;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class IssueMergeParams implements IssueMergeParamsInterface {

  public UpdateIssueParamsMergeDto mergeUpdateIssue(UUID issueId, UpdateIssueParamsDto params) {

    return new UpdateIssueParamsMergeDto(
        params.getStage(),
        issueId,
        new Date());
  }

}
