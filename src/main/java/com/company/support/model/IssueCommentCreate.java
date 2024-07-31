package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
public class IssueCommentCreate {
    @NonNull
    private String description;
    @NonNull
    private UUID clientId;
    @NonNull
    private String clientName;
}
