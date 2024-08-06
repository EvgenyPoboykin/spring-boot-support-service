package com.company.support.dto.mappers;

import com.company.support.dto.model.IssueEntity;
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

  public IssueEntity mapJsonToEntity(IssueJsonDto args) {

    return modelMapper.map(args, IssueEntity.class);
  }

  public IssueJsonDto mapEntityToJson(IssueEntity args) {
      return new IssueJsonDto(
              args.getId(),
              args.getTargetUri(),
              args.getImage(),
              args.getDescription(),
              args.getStage(),
              args.getClientName(),
              args.getCreatedAt(),
              args.getUpdatedAt()
      );
  }

  public List<IssueJsonDto> mapStreamToList(Stream<IssueEntity> issues) {
    return issues
        .map(this::mapEntityToJson)
        .collect(Collectors.toList());
  }

  public IssueEntity mapCreateIssueJsonToEntity(CreateIssueParamsDto args) {
    return modelMapper.map(args, IssueEntity.class);
  }

}
