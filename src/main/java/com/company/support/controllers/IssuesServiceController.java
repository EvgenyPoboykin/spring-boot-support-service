package com.company.support.controllers;

import com.company.support.constants.Stages;
import com.company.support.interfaces.IssuesServiceInterface;
import com.company.support.model.*;
import com.company.support.repository.postgres.PostgresRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "IssuesController", description = "Методы работы с заявками")
@RestController
@RequestMapping("/api/v1")
public class IssuesServiceController implements IssuesServiceInterface {
    PostgresRepository repository;

    public IssuesServiceController(PostgresRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Получить список заявок")
    @PostMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Issue> getIssues(@Valid @RequestBody IssuesDto params) {
        new Stages().findStageByValue(StagesEnum.DONE);

        return repository.getIssues(params);
    }

    @Operation(summary = "Создать новую заявку")
    @PutMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
    public int createIssue(@Valid @RequestBody IssueCreate issue) {
        return repository.createIssue(issue);
    }

    @Operation(summary = "Получить заявку по идентификатуру")
    @GetMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Issue> getIssue(@PathVariable UUID issueId) {

        return repository.getIssue(issueId);
    }

    @Operation(summary = "Изменить этап обработки заявки")
    @PatchMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateIssue(@PathVariable UUID issueId, @Valid @RequestBody IssueUpdate issue) {

        return repository.updateIssue(issueId, issue);
    }

}
