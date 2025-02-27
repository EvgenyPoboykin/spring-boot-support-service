package com.company.support.controllers;

import com.company.support.model.*;
import com.company.support.model.IssueComment;
import com.company.support.model.IssueCommentCreate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface CommentsServiceInterface {

    List<IssueComment> getComments(@PathVariable UUID issueId);

    int addComment(@PathVariable UUID issueId, @RequestBody IssueCommentCreate issue);

}
