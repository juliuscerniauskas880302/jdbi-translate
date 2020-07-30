package com.juliuscerniauskas.visma.translatorjdbi.model.mapper;

import com.juliuscerniauskas.visma.translatorjdbi.model.Translation;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TranslationMapper implements RowMapper<Translation> {
    @Override
    public Translation map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Translation(
                rs.getLong("ID"),
                rs.getLong("TEXT_ID"),
                rs.getString("LANGUAGE"),
                rs.getString("TRANSLATION")
        );
    }
}
