package com.juliuscerniauskas.visma.translatorjdbi.model.mapper;

import com.juliuscerniauskas.visma.translatorjdbi.model.Test;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMapper implements RowMapper<Test> {
    @Override
    public Test map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Test(rs.getLong("id"), rs.getString("name"));
    }
}
