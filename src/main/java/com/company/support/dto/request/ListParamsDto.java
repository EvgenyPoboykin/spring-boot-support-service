package com.company.support.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListParamsDto {

  @Min(25)
  @Max(100)
  private int pageSize;
  @Min(1)
  private int page;

}
