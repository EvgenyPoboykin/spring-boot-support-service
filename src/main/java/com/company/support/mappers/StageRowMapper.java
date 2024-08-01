package com.company.support.mappers;

import com.company.support.model.IssueStage;
import com.company.support.model.StagesEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StageRowMapper implements RowMapper<IssueStage> {

    @Override
    public IssueStage mapRow(ResultSet resultSet, int i) throws SQLException {
        return new IssueStage(
                StagesEnum.valueOf(resultSet.getString("value")),
                resultSet.getString("label")
        );
    }
}
