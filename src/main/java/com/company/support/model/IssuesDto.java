package com.company.support.model;

import lombok.Data;

@Data
public class IssuesDto {
    private int pageSize;
    private int page;

    public int pageSize() {
        return pageSize;
    }

    public int page() {
        return page;
    }
}
