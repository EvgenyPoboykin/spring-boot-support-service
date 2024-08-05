package com.company.support.dto.request;

import com.company.support.dto.model.StagesEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIssueParamsDto {

  @NotNull
  @NotBlank(message = "stage is required field")
  @Enumerated(EnumType.STRING)
  @JsonProperty
  private StagesEnum stage;

}

