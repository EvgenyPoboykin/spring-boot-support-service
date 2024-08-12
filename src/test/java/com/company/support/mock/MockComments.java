package com.company.support.mock;

import com.company.support.dto.request.CreateCommentParamsMerge;


public class MockComments {

  private final MockAssets assets = new MockAssets();

  public final CreateCommentParamsMerge comment_1 () {
    return new CreateCommentParamsMerge("testing", assets.issueId_0, assets.clientId_1, assets.clientName_1);
  }


}
