package com.company.support.dto.mappers;

import com.company.support.dto.request.CreateCommentParamsMerge;
import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.CommentJsonDto;

import java.util.List;
import java.util.stream.Stream;

public interface CommentMapperInterface {

  CommentEntity mapCreateCommentJsonToEntity(CreateCommentParamsMerge args);

  CommentEntity mapJsonToEntity(CommentJsonDto args);

  CommentJsonDto mapEntityToJson(CommentEntity args);

  List<CommentJsonDto> mapStreamToList(Stream<CommentEntity> comments);

}
