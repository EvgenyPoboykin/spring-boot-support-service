package com.company.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Data
@AllArgsConstructor
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
}