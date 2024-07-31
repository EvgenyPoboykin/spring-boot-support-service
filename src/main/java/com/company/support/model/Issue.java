package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
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
}





