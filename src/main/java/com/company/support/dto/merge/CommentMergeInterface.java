package com.company.support.dto.merge;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.request.CreateCommentParamsMerge;

import java.util.UUID;

public interface CommentMergeInterface {

  CreateCommentParamsMerge mergeAddCommentParams(UUID issueId, CreateCommentParamsDto property);

}
