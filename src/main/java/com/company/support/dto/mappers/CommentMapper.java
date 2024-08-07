package com.company.support.dto.mappers;

import com.company.support.dto.request.CreateCommentParamsMerge;
import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.CommentJsonDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public final class CommentMapper implements CommentMapperInterface {

  private final ModelMapper modelMapper;

  public CommentMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public CommentEntity mapCreateCommentJsonToEntity(CreateCommentParamsMerge args) {
    return modelMapper.map(args, CommentEntity.class);
  }

  public CommentEntity mapJsonToEntity(CommentJsonDto args) {
    return modelMapper.map(args, CommentEntity.class);
  }

  public CommentJsonDto mapEntityToJson(CommentEntity args) {
    return new CommentJsonDto(
        args.getId(),
        args.getIssueId(),
        args.getDescription(),
        args.getCreatedAt(),
        args.getClientName());
  }

  public List<CommentJsonDto> mapStreamToList(Stream<CommentEntity> comments) {
    return comments.map(this::mapEntityToJson).collect(Collectors.toList());
  }

}
