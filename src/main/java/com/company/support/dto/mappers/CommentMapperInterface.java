package com.company.support.dto.mappers;

import com.company.support.dto.request.CreateCommentParamsMergeDto;
import com.company.support.dto.model.CommentEntityDto;
import com.company.support.dto.model.CommentJsonDto;

import java.util.List;
import java.util.stream.Stream;

public interface CommentMapperInterface {

  CommentEntityDto mapCreateCommentJsonToEntity(CreateCommentParamsMergeDto args);

  CommentEntityDto mapJsonToEntity(CommentJsonDto args);

  CommentJsonDto mapEntityToJson(CommentEntityDto args);

  List<CommentJsonDto> mapStreamToList(Stream<CommentEntityDto> comments);

}
