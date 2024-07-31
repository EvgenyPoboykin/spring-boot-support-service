package com.company.support.model;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class IssueCommentCreate {

    @NonNull
    private String description;
    @NonNull
    private UUID clientId;
    @NonNull
    private String clientName;

    public IssueCommentCreate(String description, UUID clientId, String clientName) {
        this.description = description;
        this.clientId = clientId;
        this.clientName = clientName;
    }

    public String description() {
        return description;
    }

    public UUID clientId() {
        return clientId;
    }

    public String clientName() {
        return clientName;
    }
}
