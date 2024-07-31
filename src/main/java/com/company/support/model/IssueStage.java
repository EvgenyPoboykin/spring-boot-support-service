package com.company.support.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueStage {
    private String value;
    private String label;

    public IssueStage(String value, String label){
        this.label = label;
        this.value = value;
    }
}
