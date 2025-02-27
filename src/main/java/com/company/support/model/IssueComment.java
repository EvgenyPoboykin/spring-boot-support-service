package com.company.support.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class IssueComment {

    private UUID id;
    private UUID issueId;
    private String description;
    private String createdAt;
    private String clientId;
    private String clientName;

    public IssueComment(UUID id, UUID issueId, String description, String createdAt, String clientId, String clientName) {
        this.id = id;
        this.issueId = issueId;
        this.description = description;
        this.createdAt = createdAt;
        this.clientId = clientId;
        this.clientName = clientName;
    }
}

