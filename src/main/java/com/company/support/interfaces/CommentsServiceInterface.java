package com.company.support.interfaces;

import com.company.support.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface CommentsServiceInterface {

    List<IssueComment> getComments(@PathVariable UUID issueId);

    int addComment(@PathVariable UUID issueId, @RequestBody IssueCommentCreate issue);

}
