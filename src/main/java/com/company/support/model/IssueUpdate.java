package com.company.support.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class IssueUpdate {
    @NonNull
    private Stages stage;

    public IssueUpdate(Stages stage, String updateAt) {
        this.stage = stage;
    }

    public Stages stage() {
        return stage;
    }
}