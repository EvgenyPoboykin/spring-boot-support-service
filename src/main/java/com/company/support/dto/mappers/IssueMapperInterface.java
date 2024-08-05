package com.company.support.dto.mappers;

import com.company.support.dto.model.IssueEntityDto;
import com.company.support.dto.model.IssueJsonDto;
import com.company.support.dto.request.CreateIssueParamsDto;

import java.util.List;
import java.util.stream.Stream;

public interface IssueMapperInterface {

  IssueEntityDto mapJsonToEntity(IssueJsonDto args);

  IssueJsonDto mapEntityToJson(IssueEntityDto args);

  List<IssueJsonDto> mapStreamToList(Stream<IssueEntityDto> issues);

  IssueEntityDto mapCreateIssueJsonToEntity(CreateIssueParamsDto args);

}
