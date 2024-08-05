package com.company.support.dto.merge;

import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsMergeDto;

import java.util.UUID;

public interface IssueMergeParamsInterface {

  UpdateIssueParamsMergeDto mergeUpdateIssue(UUID issueId, UpdateIssueParamsDto params);

}
