package com.company.support.api;

import com.company.support.dto.model.CommentJsonDto;
import com.company.support.dto.request.CreateCommentParamsDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1")
public interface CommentsControllerInterface {

  @GetMapping(path = "/comments/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  List<CommentJsonDto> getComments(@PathVariable UUID issueId, @RequestParam(name = "pageSize", defaultValue = "25") @Min(5) @Max(100) int pageSize, @RequestParam(name = "page", defaultValue = "1") @Min(1) int page);

  @PutMapping(path = "/comments/{issueId}", produces = MediaType.APPLICATION_JSON_VALUE)
  CommentJsonDto addComment(@PathVariable UUID issueId, @Valid @RequestBody CreateCommentParamsDto comment);

}
