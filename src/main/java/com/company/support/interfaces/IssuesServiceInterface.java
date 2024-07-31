package com.company.support.interfaces;

import com.company.support.model.*;
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
