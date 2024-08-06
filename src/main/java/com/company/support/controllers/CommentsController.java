package com.company.support.controllers;

import com.company.support.api.CommentsControllerInterface;
import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.model.CommentJsonDto;
import com.company.support.services.comments.CommentsServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CommentsController", description = "Методы работы с комментариями")
@RestController
@RequiredArgsConstructor
public class CommentsController implements CommentsControllerInterface {

  public final CommentsServiceInterface commentsService;

  @Override
  @Operation(summary = "Получить все комментарии по заявке")
  public List<CommentJsonDto> getComments(@PathVariable UUID issueId, @RequestParam(name = "pageSize", defaultValue = "25") int pageSize, @RequestParam(name = "page", defaultValue = "1") int page) {
    return commentsService.getComments(issueId);
  }

  @Override
  @Operation(summary = "Добавить комментарий к заявке")
  public CommentJsonDto addComment(@PathVariable UUID issueId, @Valid @RequestBody CreateCommentParamsDto comment) {
    return commentsService.addComment(issueId, comment);
  }

}
