package com.company.support.controllers;

import com.company.support.api.IssuesControllerInterface;
import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;
import com.company.support.dto.request.ListParamsDto;
import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.response.SuccessUpdateDto;
import com.company.support.services.issues.IssuesServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "IssuesController", description = "Методы работы с заявками")
@RestController
@RequiredArgsConstructor
public class IssuesController implements IssuesControllerInterface {

  public final IssuesServiceInterface issuesService;

  @Operation(summary = "Получить список заявок")
  public List<IssueJsonDto> getIssues(@Valid @RequestBody ListParamsDto params) {

    return issuesService.getIssues(params);

  }

  @Operation(summary = "Получить заявку по идентификатуру")
  public Optional<IssueJsonDto> getIssue(@PathVariable UUID issueId) {

    return issuesService.getIssue(issueId);

  }

  @Operation(summary = "Изменить этап обработки заявки")
  public SuccessUpdateDto updateIssue(@PathVariable UUID issueId, @Valid @RequestBody UpdateIssueParamsDto issue) {

    return issuesService.updateIssue(issueId, issue);

  }

  @Operation(summary = "Создать заявку")
  public IssueJsonDto createIssue(@Valid @RequestBody CreateIssueParamsDto issue) {

    return issuesService.createIssue(issue);

  }

}
