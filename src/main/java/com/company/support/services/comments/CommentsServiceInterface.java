package com.company.support.services.comments;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.model.CommentJsonDto;
import com.company.support.dto.response.ListJsonDto;

import java.util.List;
import java.util.UUID;

public interface CommentsServiceInterface {

  ListJsonDto<List<CommentJsonDto>> getComments(UUID issueId, int pageSize, int page);

  CommentJsonDto addComment(UUID issueId, CreateCommentParamsDto issue);

}
