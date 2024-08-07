package com.company.support.dto.merge;

import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsMerge;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class IssueMergeParams implements IssueMergeParamsInterface {

  public UpdateIssueParamsMerge mergeUpdateIssue(UUID issueId, UpdateIssueParamsDto params) {

    return new UpdateIssueParamsMerge(
        params.getStage(),
        issueId,
        LocalDate.now());
  }

}
