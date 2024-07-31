package com.company.support.controllers;

import com.company.support.model.Issue;
import com.company.support.model.IssueCreate;
import com.company.support.model.IssueUpdate;
import com.company.support.model.IssuesDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IssuesServiceInterface {

    int createIssue(@RequestBody IssueCreate issue);

    List<Issue> getIssues(@RequestBody IssuesDto params);

    Optional<Issue> getIssue(@PathVariable UUID issueId);

    int updateIssue(@PathVariable UUID issueId, @RequestBody IssueUpdate issue);

}
