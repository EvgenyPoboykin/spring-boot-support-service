package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueStage {
    private Stages value;
    private String label;
}
