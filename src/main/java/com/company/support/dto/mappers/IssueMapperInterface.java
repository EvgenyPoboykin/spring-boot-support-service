package com.company.support.dto.mappers;

import com.company.support.dto.model.IssueEntity;
import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;

import java.util.List;
import java.util.stream.Stream;

public interface IssueMapperInterface {

  IssueEntity mapJsonToEntity(IssueJsonDto args);

  IssueJsonDto mapEntityToJson(IssueEntity args);

  List<IssueJsonDto> mapStreamToList(Stream<IssueEntity> issues);

  IssueEntity mapCreateIssueJsonToEntity(CreateIssueParamsDto args);

}
