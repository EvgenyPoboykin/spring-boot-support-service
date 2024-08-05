package com.company.support.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListJsonDto<T> {

  @JsonProperty
  T[] records;
  @JsonProperty
  int pageSize;
  @JsonProperty
  int page;
  @JsonProperty
  int pageTotal;
  @JsonProperty
  int totalCount;

}
