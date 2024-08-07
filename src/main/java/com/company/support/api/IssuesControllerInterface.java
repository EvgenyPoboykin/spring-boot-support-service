
package com.company.support.api;

import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.response.ListJsonDto;
import com.company.support.dto.response.SuccessDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1")
public interface IssuesControllerInterface {

  @GetMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
  ListJsonDto<List<IssueJsonDto>> getIssues(@RequestParam(name = "pageSize", defaultValue = "25") @Min(5) @Max(100) int pageSize, @RequestParam(name = "page", defaultValue = "1") @Min(1) int page);

  @PutMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
  IssueJsonDto createIssue(@Valid @RequestBody CreateIssueParamsDto issue);

  @GetMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  Optional<IssueJsonDto> getIssue(@PathVariable UUID issueId);

  @PatchMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  SuccessDto updateIssue(@PathVariable UUID issueId, @Valid @RequestBody UpdateIssueParamsDto issue);

  @DeleteMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  SuccessDto deleteIssue(@PathVariable UUID issueId);

}
