package com.company.support.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateIssueParamsDto {

  @NotNull(message = "targetUri is not a null")
  @NotBlank(message = "targetUri is required field")
  private String targetUri;
  private String image;
  @NotNull(message = "description is not a null")
  @NotBlank(message = "description is required field")
  private String description;
  private UUID clientId;
  @NotNull(message = "clientName is not a null")
  @NotBlank(message = "clientName is required field")
  private String clientName;

}

