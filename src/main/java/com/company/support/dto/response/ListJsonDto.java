package com.company.support.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListJsonDto<T> {

  @JsonProperty
  T records;
  @JsonProperty
  int pageSize;
  @JsonProperty
  int page;
  @JsonProperty
  int totalPage;
  @JsonProperty
  int totalCount;

}
