package com.company.support.controllers;

import com.company.support.interfaces.CommentsServiceInterface;
import com.company.support.model.*;
import com.company.support.repository.postgres.PostgresRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CommentsController", description = "Методы работы с комментариями")
@RestController
@RequestMapping("/api/v1")
public class CommentsServiceController implements CommentsServiceInterface {
    PostgresRepository repository;

    public CommentsServiceController(PostgresRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Получить все комментарии по заявке")
    @GetMapping(path = "/comments/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IssueComment> getComments(@PathVariable UUID issueId) {
        return repository.getComments(issueId);
    }

    @Operation(summary = "Добавить комментарий к заявке")
    @PutMapping(path = "/comments/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int addComment(@PathVariable UUID issueId, @Valid @RequestBody IssueCommentCreate comment) {
        return repository.addComment(issueId, comment);
    }
}
