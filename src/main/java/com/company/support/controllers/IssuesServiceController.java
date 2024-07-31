package com.company.support.controllers;

import com.company.support.model.Issue;
import com.company.support.model.IssueCreate;
import com.company.support.model.IssueUpdate;
import com.company.support.model.IssuesDto;
import com.company.support.repository.postgres.RepositoryIssues;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "IssuesController", description = "Методы работы с заявками")
@RestController
@RequestMapping("/api/v1")
public class IssuesServiceController implements IssuesServiceInterface {

    @Autowired
    RepositoryIssues repository;

    @PostMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Issue> getIssues(@RequestBody IssuesDto params) {
        return repository.getIssues(params);
    }

    @PutMapping(path = "/issues", produces = MediaType.APPLICATION_JSON_VALUE)
    public int createIssue(@RequestBody IssueCreate issue) {
        return repository.createIssue(issue);
    }

    @GetMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Issue> getIssue(@PathVariable UUID issueId) {
        return repository.getIssue(issueId);
    }

    @PatchMapping(path = "/issues/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateIssue(@PathVariable UUID issueId, @RequestBody IssueUpdate issue) {
        return repository.updateIssue(issueId, issue);
    }

}
