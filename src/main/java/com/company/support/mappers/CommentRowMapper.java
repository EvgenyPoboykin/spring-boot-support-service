package com.company.support.mappers;

import com.company.support.model.IssueComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CommentRowMapper implements RowMapper<IssueComment> {

    @Override
    public IssueComment mapRow(ResultSet resultSet, int i) throws SQLException {
        return new IssueComment(
                UUID.fromString(resultSet.getString("id")),
                UUID.fromString(resultSet.getString("issue_id")),
                resultSet.getString("description"),
                resultSet.getString("created_at"),
                resultSet.getString("client_id"),
                resultSet.getString("client_name")
        );
    }
}
