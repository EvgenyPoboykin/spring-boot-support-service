package com.company.support.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueCommentCreate {

    private String description;
    private String clientId;
    private String clientName;

    public IssueCommentCreate(String description, String clientId, String clientName) {
        this.description = description;
        this.clientId = clientId;
        this.clientName = clientName;
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
