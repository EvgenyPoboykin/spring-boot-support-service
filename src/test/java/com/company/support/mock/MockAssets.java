package com.company.support.mock;

import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.request.CreateCommentParamsMerge;

import java.util.UUID;

public class MockAssets {
  public final UUID clientId_1 = UUID.fromString("209da369-850b-4a8d-9c0f-2c34a79956a6");

  public final String clientName_1 = "Ivanov Ivan";

  public final UUID issueId_0 = UUID.fromString("24932697-4059-44fe-a8ee-f40a6755417d");

  public final UUID issueId_1 =  UUID.fromString("39b577bb-9370-4b2c-8a63-db02dd36b1d4");

  public final CommentEntity comment_0 = CommentEntity
            .builder()
            .issueId(issueId_0)
            .description("test 0")
            .clientId(clientId_1)
            .clientName(clientName_1).build();

  public final CommentEntity comment_1 = CommentEntity
            .builder()
            .issueId(issueId_1)
            .description("test 1")
            .clientId(clientId_1)
            .clientName(clientName_1).build();

}
