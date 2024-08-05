package com.company.support.dto.mappers;

import com.company.support.dto.request.CreateCommentParamsMergeDto;
import com.company.support.dto.model.CommentEntityDto;
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

  public CommentEntityDto mapCreateCommentJsonToEntity(CreateCommentParamsMergeDto args) {
    return modelMapper.map(args, CommentEntityDto.class);
  }

  public CommentEntityDto mapJsonToEntity(CommentJsonDto args) {
    return modelMapper.map(args, CommentEntityDto.class);
  }

  public CommentJsonDto mapEntityToJson(CommentEntityDto args) {
    return modelMapper.map(args, CommentJsonDto.class);
  }

  public List<CommentJsonDto> mapStreamToList(Stream<CommentEntityDto> comments) {
    return comments.map(this::mapEntityToJson).collect(Collectors.toList());
  }

}
