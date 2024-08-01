package com.company.support.repository.postgres;

import com.company.support.interfaces.RepositoryInterface;
import com.company.support.mappers.CommentRowMapper;
import com.company.support.mappers.IssueRowMapper;
import com.company.support.mappers.StageRowMapper;
import com.company.support.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresRepository implements RepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Issue> getIssues(IssuesDto params) {
        var sql = "SELECT * FROM issue ORDER BY created_at DESC LIMIT ? OFFSET ?";

        PageRequest pageable =  PageRequest.of(params.getPage() - 1, params.getPageSize());

        System.out.println(pageable.getPageSize() + " -- " + pageable.getOffset());
        return jdbcTemplate.query(
                sql,
                new IssueRowMapper(),
                pageable.getPageSize(),
                pageable.getOffset()
        );
    }

    @Override
    public Optional<Issue> getIssue(UUID issueId) {
        var sql = "SELECT * FROM issue WHERE id = ?";
        List<Issue> issues = jdbcTemplate.query(sql, new IssueRowMapper(), issueId);

        return issues.stream().findFirst();
    }

    @Override
    public List<IssueStage> getStages() {
        var sql = "SELECT * FROM stage";

        return jdbcTemplate.query(sql, new StageRowMapper());
    }

    @Override
    public int createIssue(IssueCreate issue) {
        var sql = "INSERT INTO issue(target_uri, image, description, created_at, updated_at, client_id, client_name) VALUES (?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                issue.getTargetUri(),
                issue.getImage(),
                issue.getDescription(),
                new Date(),
                new Date(),
                issue.getClientId(),
                issue.getClientName()
        );
    }

    @Override
    public int updateIssue(UUID issueId, IssueUpdate issue) {
        var sql = "UPDATE issue SET stage = ? , updated_at = ? WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                issue.getStage(),
                new Date(),
                issueId
        );
    }

    @Override
    public List<IssueComment> getComments(UUID issueId) {
        var sql = "SELECT * FROM comment ORDER BY created_at DESC WHERE issue_id = ?";

        return jdbcTemplate.query(sql, new CommentRowMapper(), issueId);
    }

    @Override
    public int addComment(UUID issueId, IssueCommentCreate comment) {
        var sql = "INSERT INTO comment(issue_id, description, client_id, client_name) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                issueId,
                comment.getDescription(),
                comment.getClientId(),
                comment.getClientName()
        );
    }

    @Override
    public List<IssueStage> findStageByValue(Stages stage){
        var sql = "SELECT * FROM stage WHERE value = ?";

        return jdbcTemplate.query(sql, new StageRowMapper(), stage);
    }
}
