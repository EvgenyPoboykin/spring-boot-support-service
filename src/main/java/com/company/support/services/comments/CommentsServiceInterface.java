package com.company.support.services.comments;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.model.CommentJsonDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface CommentsServiceInterface {

  List<CommentJsonDto> getComments(@PathVariable UUID issueId);

  CommentJsonDto addComment(@PathVariable UUID issueId, @RequestBody CreateCommentParamsDto issue);

}
