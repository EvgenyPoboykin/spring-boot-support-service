package com.company.support.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateCommentParamsMerge {

  private String description;
  private UUID issueId;
  private UUID clientId;
  private String clientName;

}
