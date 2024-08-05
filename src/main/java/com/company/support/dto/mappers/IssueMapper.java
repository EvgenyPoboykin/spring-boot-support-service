package com.company.support.dto.mappers;

import com.company.support.dto.model.IssueEntityDto;
import com.company.support.dto.model.IssueJsonDto;

import com.company.support.dto.request.CreateIssueParamsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public final class IssueMapper implements IssueMapperInterface {

  private final ModelMapper modelMapper;

  public IssueMapper(ModelMapper modelMapper) {

    this.modelMapper = modelMapper;
  }

  public IssueEntityDto mapJsonToEntity(IssueJsonDto args) {

    return modelMapper.map(args, IssueEntityDto.class);
  }

  public IssueJsonDto mapEntityToJson(IssueEntityDto args) {

    return modelMapper.map(args, IssueJsonDto.class);
  }

  public List<IssueJsonDto> mapStreamToList(Stream<IssueEntityDto> issues) {
    return issues
        .map(this::mapEntityToJson)
        .collect(Collectors.toList());
  }

  public IssueEntityDto mapCreateIssueJsonToEntity(CreateIssueParamsDto args) {
    return modelMapper.map(args, IssueEntityDto.class);
  }

}
