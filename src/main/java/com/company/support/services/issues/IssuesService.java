package com.company.support.services.issues;

import com.company.support.dto.mappers.IssueMapperInterface;
import com.company.support.dto.merge.IssueMergeParamsInterface;
import com.company.support.dto.model.IssueEntity;
import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsMerge;
import com.company.support.dto.response.ListJsonDto;
import com.company.support.dto.response.SuccessDto;
import com.company.support.exception.NoFoundException;
import com.company.support.repository.IssueRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IssuesService implements IssuesServiceInterface {
  public final IssueRepositoryInterface repository;
  public final IssueMapperInterface mapper;
  public final IssueMergeParamsInterface merge;

  private List<IssueJsonDto> getIssuesByClient(UUID id, int limit, Long offset){
    List<IssueEntity> issues = repository.findByClientId(id, limit, offset);

    return mapper.mapStreamToList(issues.stream());
  }

  private List<IssueJsonDto> getIssuesByAdmin(int limit, Long offset){
    List<IssueEntity> issues = new ArrayList<>();

    Iterable<IssueEntity> issuesAdmin = repository.findByAdmin(limit, offset);

    issuesAdmin.forEach(issues::add);

    return mapper.mapStreamToList(issues.stream());
  }

  public ListJsonDto<List<IssueJsonDto>> getIssues(int pageSize, int page) {
    // убрать после перехода на jwt
    var clientId = UUID.fromString("71aa2970-4f55-4ca2-977e-9606d0c53e9a");

    int PAGE_ONE = 1;
    Pageable pageable = PageRequest.of(page - PAGE_ONE, pageSize);

    if (!clientId.toString().isEmpty()) {

      long totalCount = repository.findByClientIdCount(clientId);

      List<IssueJsonDto> records = getIssuesByClient(clientId, pageable.getPageSize(), pageable.getOffset());

      return new ListJsonDto<List<IssueJsonDto>>(
          records,
          pageable.getPageSize(),
          pageable.getPageNumber() + PAGE_ONE,
          (int)(totalCount / pageable.getPageSize()) + PAGE_ONE,
          (int)totalCount
      );

    } else {

      long totalCount = repository.findByAdminCount();

      List<IssueJsonDto> records = getIssuesByAdmin(pageable.getPageSize(), pageable.getOffset());

      return new ListJsonDto<List<IssueJsonDto>>(
              records,
              pageable.getPageSize(),
              pageable.getPageNumber() + PAGE_ONE,
              (int)(totalCount / pageable.getPageSize()) + PAGE_ONE,
              (int)totalCount
      );

    }

  }

  public Optional<IssueJsonDto> getIssue(UUID issueId) {

    if(!repository.existsById(issueId)){
      throw new NoFoundException("Issue with id=" + issueId + " is not exists!");
    }

    return repository.findById(issueId).map(mapper::mapEntityToJson);

  }

  public SuccessDto updateIssue(UUID issueId, UpdateIssueParamsDto body) {

    if(!repository.existsById(issueId)){
      throw new NoFoundException("Issue with id=" + issueId + " is not exists!");
    }

    UpdateIssueParamsMerge params = merge.mergeUpdateIssue(issueId, body);

    repository.updateIssue(params.getStage(), params.getUpdatedAt(), params.getIssueId());

    return new SuccessDto(true);

  }

  public SuccessDto deleteIssue(UUID issueId) {

    if(!repository.existsById(issueId)){
      throw new NoFoundException("Issue with id=" + issueId + " is not exists!");
    }

    // убрать после перехода на jwt
    var clientId = UUID.fromString("71aa2970-4f55-4ca2-977e-9606d0c53e9a");

    repository.deleteIssue(issueId, clientId);

    return new SuccessDto(true);

  }

  public IssueJsonDto createIssue(CreateIssueParamsDto body) {

    IssueEntity issueSave = mapper.mapCreateIssueJsonToEntity(body);

    IssueEntity issue = repository.save(issueSave);

    return mapper.mapEntityToJson(issue);

  }

}
