package com.company.support.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateIssueParamsDto {

  @NotBlank(message = "targetUri is required field")
  @JsonProperty
  private String targetUri;
  private String image;
  @NotBlank(message = "description is required field")
  @JsonProperty
  private String description;
  @NotBlank(message = "clientId is required field")
  @JsonProperty
  private UUID clientId;
  @NotBlank(message = "clientName is required field")
  @JsonProperty
  private String clientName;

}

