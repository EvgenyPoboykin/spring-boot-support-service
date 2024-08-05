
package com.company.support.api;

import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;
import com.company.support.dto.request.ListParamsDto;
import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.response.SuccessUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1")
public interface IssuesControllerInterface {

  @PostMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
  List<IssueJsonDto> getIssues(@Valid @RequestBody ListParamsDto params);

  @PutMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
  IssueJsonDto createIssue(@Valid @RequestBody CreateIssueParamsDto issue);

  @GetMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  Optional<IssueJsonDto> getIssue(@PathVariable UUID issueId);

  @PatchMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  SuccessUpdateDto updateIssue(@PathVariable UUID issueId, @Valid @RequestBody UpdateIssueParamsDto issue);

}
