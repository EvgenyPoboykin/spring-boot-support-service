package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class IssueComment {
    private UUID id;
    private UUID issueId;
    private String description;
    private String createdAt;
    private String clientId;
    private String clientName;
}

