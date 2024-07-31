package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class IssueUpdate {
    @NonNull
    private Stages stage;
}