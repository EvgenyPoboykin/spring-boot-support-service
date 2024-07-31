package com.company.support.repository.postgres;

import com.company.support.exception.NoFoundStageValueException;
import com.company.support.mappers.CommentRowMapper;
import com.company.support.mappers.IssueRowMapper;
import com.company.support.mappers.StageRowMapper;
import com.company.support.model.*;
import com.company.support.query.Query;

import com.company.support.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RepositoryIssues implements RepositoryInterface {
    Query query = new Query();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Issue> getIssues(IssuesDto params) {

        Pagination page = new Pagination(params.pageSize(), params.page());

        return jdbcTemplate.query(
                query.getIssues(),
                new IssueRowMapper(),
                page.limit(),
                page.offset()
        );
    }

    @Override
    public Optional<Issue> getIssue(UUID issueId) {

        List<Issue> issues = jdbcTemplate.query(query.getIssue(), new IssueRowMapper(), issueId);
        Optional<Issue> issue = issues.stream().findFirst();

        if(issue.isEmpty()){
            throw new NoFoundStageValueException("Cannot find issue with id = " + issueId);
        }

        return issue;
    }

    @Override
    public List<IssueStage> getStages() {

        return jdbcTemplate.query(query.getStages(), new StageRowMapper());
    }

    @Override
    public int createIssue(IssueCreate issue) {

        return jdbcTemplate.update(
                query.createIssue(),
                issue.targetUri(),
                issue.image(),
                issue.description(),
                new Date(),
                new Date(),
                issue.clientId(),
                issue.clientName()
        );
    }

    @Override
    public int updateIssue(UUID issueId, IssueUpdate issue) {

        List<IssueStage> option = jdbcTemplate.query(query.getStageByValue(), new StageRowMapper(), issue.stage());

        if((long) option.size() == 0){
            throw new NoFoundStageValueException("Cannot find stage value! You used un!");
        }

        return jdbcTemplate.update(
                query.updateIssue(),
                issue.stage(),
                new Date(),
                issueId
        );
    }

    @Override
    public List<IssueComment> getComments(UUID issueId) {

        return jdbcTemplate.query(query.getComments(), new CommentRowMapper(), issueId);
    }

    @Override
    public int addComment(UUID issueId, IssueCommentCreate comment) {

        return jdbcTemplate.update(
                query.addComment(),
                issueId,
                comment.description(),
                comment.clientId(),
                comment.clientName()
        );
    }
}
