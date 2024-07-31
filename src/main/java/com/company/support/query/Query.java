package com.company.support.query;

import org.springframework.stereotype.Service;

@Service
public class Query {

    public String getIssues(){
        return "SELECT * FROM issue ORDER BY created_at DESC LIMIT ? OFFSET ?";
    }

    public String getIssuesByEmployee(){
        return "SELECT * FROM issue WHERE client_id = ? ORDER BY created_at DESC LIMIT ? OFFSET ?";
    }

    public String getIssue(){
        return "SELECT * FROM issue WHERE id = ?";
    }

    public String createIssue(){
        return "INSERT INTO issue(target_uri, image, description, created_at, updated_at, client_id, client_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public String updateIssue(){
        return "UPDATE issue SET stage = ? , updated_at = ? WHERE id = ?";
    }

    public String getStages(){
        return "SELECT * FROM stage";
    }

    public String getStageByValue(){
        return "SELECT * FROM stage WHERE value = ?";
    }

    public String getComments(){
        return "SELECT * FROM comment ORDER BY created_at DESC WHERE issue_id = ?";
    }

    public String addComment(){
        return "INSERT INTO comment(issue_id, description, client_id, client_name) VALUES (?, ?, ?, ?)";
    }
}
