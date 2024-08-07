package com.company.support.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListParamsDto {

  @Min(value = 25, message = "pageSize min value must to be >= 25")
  @Max(value = 100, message = "pageSize max value must to be <= 101")
  private int pageSize;
  @Min(value = 1, message = "page min value must to be > 0")
  private int page;

}
