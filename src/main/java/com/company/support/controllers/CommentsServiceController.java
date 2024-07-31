package com.company.support.controllers;

import com.company.support.model.IssueComment;
import com.company.support.model.IssueCommentCreate;
import com.company.support.repository.postgres.RepositoryIssues;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CommentsController", description = "Методы работы с комментариями")
@RestController
@RequestMapping("/api/v1")
public class CommentsServiceController implements CommentsServiceInterface {
    @Autowired
    RepositoryIssues repository;

    @Operation(summary = "Получить все комментарии по заявке")
    @GetMapping(path = "/comments/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IssueComment> getComments(@PathVariable UUID issueId) {
        return repository.getComments(issueId);
    }

    @Operation(summary = "Добавить комментарий к заявке")
    @PutMapping(path = "/comments/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int addComment(@PathVariable UUID issueId, @RequestBody IssueCommentCreate comment) {
        return repository.addComment(issueId, comment);
    }
}
