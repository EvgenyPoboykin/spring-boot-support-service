package com.company.support.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ListParamsDto {

  @Min(25)
  private int pageSize;
  @Min(1)
  private int page;

}
