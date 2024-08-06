package com.company.support.dto.merge;

import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsMerge;

import java.util.UUID;

public interface IssueMergeParamsInterface {

  UpdateIssueParamsMerge mergeUpdateIssue(UUID issueId, UpdateIssueParamsDto params);

}
