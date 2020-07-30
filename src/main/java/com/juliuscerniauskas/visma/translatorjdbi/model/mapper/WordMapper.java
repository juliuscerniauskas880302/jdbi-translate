package com.juliuscerniauskas.visma.translatorjdbi.model.mapper;

import com.juliuscerniauskas.visma.translatorjdbi.model.Word;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WordMapper implements RowMapper<Word> {
    @Override
    public Word map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Word(rs.getLong("ID"), rs.getString("TEXT"));
    }
}
