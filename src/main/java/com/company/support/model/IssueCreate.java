package com.company.support.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueCreate {
    private String targetUri;
    private String image;
    private String description;
    private String clientId;
    private String clientName;


    public IssueCreate(String targetUri, String image, String description, String clientId, String clientName) {
        this.targetUri = targetUri;
        this.image = image;
        this.description = description;
        this.clientId = clientId;
        this.clientName = clientName;
    }

    public String targetUri() {
        return targetUri;
    }

    public String image() {
        return image;
    }

    public String description() {
        return description;
    }

    public String clientId() {
        return clientId;
    }

    public String clientName() {
        return clientName;
    }
}