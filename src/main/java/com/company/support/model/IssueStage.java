package com.company.support.model;

import lombok.Data;

@Data
public class IssueStage {
    private Stages value;
    private String label;

    public IssueStage(Stages value, String label){
        this.label = label;
        this.value = value;
    }
}
