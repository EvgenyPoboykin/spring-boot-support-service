package com.company.support.dto.generators;

import com.company.support.dto.response.ListJsonDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Generator implements GeneratorInterface {
  public final <T> ListJsonDto<List<T>> emptyResponseList(int pageSize, int page, int totalPage) {
    return new ListJsonDto<List<T>>(
        new ArrayList<T>(),
        pageSize,
        page,
        totalPage,
        0);
  }
}
