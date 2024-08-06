package com.company.support.services.issues;

import com.company.support.dto.mappers.IssueMapperInterface;
import com.company.support.dto.merge.IssueMergeParamsInterface;
import com.company.support.dto.model.IssueEntity;
import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;
import com.company.support.dto.request.ListParamsDto;
import com.company.support.dto.request.UpdateIssueParamsDto;
import com.company.support.dto.request.UpdateIssueParamsMerge;
import com.company.support.dto.response.SuccessDto;
import com.company.support.exception.NoFoundException;
import com.company.support.repository.IssueRepositoryInterface;
import lombok.RequiredArgsConstructor;
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

  public List<IssueJsonDto> getIssues(int pageSize, int page) {
    // убрать после перехода на jwt
    var id = UUID.randomUUID();

    if (id.toString().isEmpty()) {

      List<IssueEntity> issues = repository.findByClientId(id);

      return mapper.mapStreamToList(issues.stream());

    } else {

      List<IssueEntity> issues = new ArrayList<>();

      Iterable<IssueEntity> issuesAdmin = repository.findAll();

      issuesAdmin.forEach(issues::add);

      return mapper.mapStreamToList(issues.stream());

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
    var clientId = UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6");

    repository.deleteIssue(issueId, clientId);

    return new SuccessDto(true);

  }

  public IssueJsonDto createIssue(CreateIssueParamsDto body) {

    IssueEntity issueSave = mapper.mapCreateIssueJsonToEntity(body);

    IssueEntity issue = repository.save(issueSave);

    return mapper.mapEntityToJson(issue);

  }

}
