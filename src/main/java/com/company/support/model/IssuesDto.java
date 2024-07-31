package com.company.support.model;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class IssuesDto {
    @Min(25)
    private int pageSize;
    @Min(1)
    private int page;

    public int pageSize() {
        return pageSize;
    }

    public int page() {
        return page;
    }
}
