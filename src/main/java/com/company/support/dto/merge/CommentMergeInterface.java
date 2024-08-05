package com.company.support.dto.merge;

import com.company.support.dto.request.CreateCommentParamsDto;
import com.company.support.dto.request.CreateCommentParamsMergeDto;

import java.util.UUID;

public interface CommentMergeInterface {

  CreateCommentParamsMergeDto mergeAddCommentParams(UUID issueId, CreateCommentParamsDto property);

}
