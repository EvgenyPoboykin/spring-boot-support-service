package com.company.support.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueUpdate {
    private String stage;

    public IssueUpdate(String stage, String updateAt) {
        this.stage = stage;
    }

    public String stage() {
        return stage;
    }
}