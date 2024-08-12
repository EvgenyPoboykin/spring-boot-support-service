package com.company.support.dto.mappers;

import com.company.support.dto.request.CreateCommentParamsMerge;
import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.CommentJsonDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public final class CommentMapper implements CommentMapperInterface {

  private final ModelMapper modelMapper;

  public CommentMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public CommentEntity mapCreateCommentJsonToEntity(CreateCommentParamsMerge args) {

    return modelMapper.map(args, CommentEntity.class);
  }

  public CommentJsonDto mapEntityToJson(CommentEntity args) {

    return modelMapper.map(args, CommentJsonDto.class);
  }

}
