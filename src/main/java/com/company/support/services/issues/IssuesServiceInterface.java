
package com.company.support.services.issues;

import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;
import com.company.support.dto.request.ListParamsDto;
import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.response.SuccessDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IssuesServiceInterface {

  List<IssueJsonDto> getIssues(ListParamsDto params);

  Optional<IssueJsonDto> getIssue(UUID issueId);

  SuccessDto updateIssue(UUID issueId, UpdateIssueParamsDto issue);

  SuccessDto deleteIssue(UUID issueId);

  IssueJsonDto createIssue(CreateIssueParamsDto issue);

}
