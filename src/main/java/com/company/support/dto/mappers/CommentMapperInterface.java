package com.company.support.dto.mappers;

import com.company.support.dto.request.CreateCommentParamsMerge;
import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.CommentJsonDto;

public interface CommentMapperInterface {

  CommentEntity mapCreateCommentJsonToEntity(CreateCommentParamsMerge args);

  CommentJsonDto mapEntityToJson(CommentEntity args);

}
