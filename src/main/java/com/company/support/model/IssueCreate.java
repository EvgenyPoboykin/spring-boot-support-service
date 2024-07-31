package com.company.support.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Data
public class IssueCreate {
    @NonNull
    private String targetUri;
    @Nullable
    private String image;
    @NonNull
    private String description;
    @NonNull
    private UUID clientId;
    @Nullable
    private String clientName;


    public IssueCreate(String targetUri, String image, String description, UUID clientId, String clientName) {
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

    public UUID clientId() {
        return clientId;
    }

    public String clientName() {
        return clientName;
    }
}