package com.company.support.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Issue {

    private UUID id;
    private String targetUri;
    private String image;
    private String description;
    private String stage;
    private String clientId;
    private String clientName;
    private String createdAt;
    private String updatedAt;

    public Issue(UUID id, String targetUri, String image, String description, String stage, String clientId, String clientName, String createdAt, String updatedAt) {
        this.id = id;
        this.targetUri = targetUri;
        this.image = image;
        this.description = description;
        this.stage = stage;
        this.clientId = clientId;
        this.clientName = clientName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}





