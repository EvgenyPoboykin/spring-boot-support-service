package com.company.support.dto.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueJsonDto {

  @NotNull
  @JsonProperty
  private UUID id;
  @NotNull
  @JsonProperty
  private String targetUri;
  @JsonProperty
  private String image;
  @NotNull
  @JsonProperty
  private String description;
  @NotNull
  @JsonProperty
  @Enumerated(EnumType.STRING)
  private StagesEnum stage;
  @NotNull
  @JsonProperty
  private UUID clientId;
  @NotNull
  @JsonProperty
  private String clientName;
  @NotNull
  @JsonProperty
  private Date createdAt;
  @NotNull
  @JsonProperty
  private Date updatedAt;

}
