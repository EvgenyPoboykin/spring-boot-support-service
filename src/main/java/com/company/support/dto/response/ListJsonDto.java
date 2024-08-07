package com.company.support.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListJsonDto<T> {

  T records;
  int pageSize;
  int page;
  int totalPage;
  int totalCount;

}
