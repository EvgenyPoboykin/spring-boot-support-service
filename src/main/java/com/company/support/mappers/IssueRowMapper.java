package com.company.support.mappers;

import com.company.support.model.Issue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class IssueRowMapper implements RowMapper<Issue> {
    @Override
    public Issue mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Issue(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("target_uri"),
                resultSet.getString("image"),
                resultSet.getString("description"),
                resultSet.getString("stage"),
                resultSet.getString("client_id"),
                resultSet.getString("client_name"),
                resultSet.getString("created_at"),
                resultSet.getString("updated_at")
        );
    }
}



