package com.company.support.services.comments;

import com.company.support.dto.merge.CommentMergeInterface;
import com.company.support.dto.mappers.CommentMapperInterface;
import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.request.CreateCommentParamsMerge;
import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.CommentJsonDto;
import com.company.support.dto.response.ListJsonDto;
import com.company.support.exception.NoFoundException;
import com.company.support.repository.CommentRepositoryInterface;

import com.company.support.repository.IssueRepositoryInterface;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentsService implements CommentsServiceInterface {
  public final CommentRepositoryInterface repository;
  public final IssueRepositoryInterface issueRepository;
  public final CommentMapperInterface mapper;
  public final CommentMergeInterface mergeParams;

  public ListJsonDto<List<CommentJsonDto>> getComments(UUID issueId, int pageSize, int page) {

    if(!issueRepository.existsById(issueId)){
      throw new NoFoundException("Issue with id=" + issueId + " is not exists!");
    }

    int PAGE_ONE = 1;
    Pageable pageable = PageRequest.of(page - PAGE_ONE, pageSize);

    long totalCount = repository.findByIssueIdCount(issueId);

    List<CommentEntity> comments = repository.findByIssueId(issueId);

    List<CommentJsonDto> records = mapper.mapStreamToList(comments.stream());

    return new ListJsonDto<List<CommentJsonDto>>(
            records,
            pageable.getPageSize(),
            pageable.getPageNumber() + PAGE_ONE,
            (int)(totalCount / pageable.getPageSize()) + PAGE_ONE,
            (int)totalCount
    );

  }

  public CommentJsonDto addComment(UUID issueId, CreateCommentParamsDto body) {

    if(!issueRepository.existsById(issueId)){
      throw new NoFoundException("Issue with id=" + issueId + " is not exists!");
    }

    CreateCommentParamsMerge property = mergeParams.mergeAddCommentParams(issueId, body);

    CommentEntity data = mapper.mapCreateCommentJsonToEntity(property);

    CommentEntity comment = repository.save(data);

    return mapper.mapEntityToJson(comment);

  }

}
