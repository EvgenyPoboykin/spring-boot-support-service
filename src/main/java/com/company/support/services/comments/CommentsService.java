package com.company.support.services.comments;

import com.company.support.dto.merge.CommentMergeInterface;
import com.company.support.dto.mappers.CommentMapperInterface;
import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.request.CreateCommentParamsMergeDto;
import com.company.support.dto.model.CommentEntityDto;
import com.company.support.dto.model.CommentJsonDto;
import com.company.support.dto.validations.CommentValidationInterface;
import com.company.support.repository.CommentRepositoryInterface;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentsService implements CommentsServiceInterface {
  public final CommentRepositoryInterface repository;
  public final CommentMapperInterface mapper;
  public final CommentMergeInterface mergeParams;
  public final CommentValidationInterface validation;

  public List<CommentJsonDto> getComments(UUID issueId) {

    List<CommentEntityDto> comments = repository.findByIssueId(issueId);

    return mapper.mapStreamToList(comments.stream());

  }

  public CommentJsonDto addComment(UUID issueId, CreateCommentParamsDto body) {

    validation.validationAddCommentParams(issueId, body);

    CreateCommentParamsMergeDto property = mergeParams.mergeAddCommentParams(issueId, body);

    CommentEntityDto data = mapper.mapCreateCommentJsonToEntity(property);

    CommentEntityDto comment = repository.save(data);

    return mapper.mapEntityToJson(comment);

  }

}
