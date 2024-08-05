package com.company.support.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@NotNull(message = "body is not a null")
@NotEmpty(message = "body is required field")
public class CreateCommentParamsDto {

  @NotNull(message = "description is not a null")
  @NotEmpty(message = "description is required field")
  @JsonProperty
  private String description;
  @NotNull(message = "clientId is not a null")
  @NotEmpty(message = "clientId is required field")
  @JsonProperty
  private UUID clientId;
  @NotNull(message = "clientName is not a null")
  @NotEmpty(message = "clientName is required field")
  @JsonProperty
  private String clientName;

}
