package com.company.support.dto.generators;

import com.company.support.dto.response.ListJsonDto;

import java.util.List;

public interface GeneratorInterface {

  <T> ListJsonDto<List<T>> emptyResponseList(int pageSize, int page, int totalPage);

}
