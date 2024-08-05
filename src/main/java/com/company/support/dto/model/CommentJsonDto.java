package com.company.support.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CommentJsonDto {

  @NotNull
  @JsonProperty
  private UUID id;
  @NotNull
  @JsonProperty
  private UUID issueId;
  @NotNull
  @JsonProperty
  private String description;
  @NotNull
  @JsonProperty
  private Date createdAt;
  @NotNull
  @JsonProperty
  private UUID clientId;
  @NotNull
  @JsonProperty
  private String clientName;

}
