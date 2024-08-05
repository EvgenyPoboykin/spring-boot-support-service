package com.company.support.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateCommentParamsMergeDto {

  @JsonProperty
  private String description;
  @JsonProperty
  private UUID issueId;
  @JsonProperty
  private UUID clientId;
  @JsonProperty
  private String clientName;

}
