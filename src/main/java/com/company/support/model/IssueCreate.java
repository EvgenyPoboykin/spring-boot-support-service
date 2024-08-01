package com.company.support.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class IssueCreate {
    @NotBlank(message = "targetUri is required field")
    private String targetUri;
    private String image;
    @NotBlank(message = "description is required field")
    private String description;
    @NotBlank(message = "clientId is required field")
    private UUID clientId;
    @NotBlank(message = "clientName is required field")
    private String clientName;
}