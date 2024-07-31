package com.company.support.interfaces;

import com.company.support.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryInterface {
    List<Issue> getIssues(IssuesDto pageable);

    Optional<Issue> getIssue(UUID issueId);

    List<IssueStage> getStages();

    int createIssue(IssueCreate issue);

    int updateIssue(UUID issueId, IssueUpdate issue);

    List<IssueComment> getComments(UUID issueId);

    int addComment(UUID issueId, IssueCommentCreate comment);

    List<IssueStage> findStageByValue(Stages stage);
}
