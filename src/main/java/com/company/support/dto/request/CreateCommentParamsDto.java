package com.company.support.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateCommentParamsDto {

  @NotNull(message = "description is not a null")
  @NotEmpty(message = "description is required field")
  private String description;
  private UUID clientId;
  @NotNull(message = "clientName is not a null")
  @NotEmpty(message = "clientName is required field")
  private String clientName;

}
