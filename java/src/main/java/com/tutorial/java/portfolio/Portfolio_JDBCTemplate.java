package com.tutorial.java.portfolio;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Portfolio_JDBCTemplate {
    private final JdbcTemplate template;

    public void saveBulkSomething(List<TestEntity> newClient) {
        final String insertSQL = "INSERT INTO " +
                "test_entity (something) " +
                "VALUES(?)";

        template.batchUpdate(insertSQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                TestEntity client = newClient.get(i);
                ps.setInt(1, client.getSomething());
            }

            @Override
            public int getBatchSize() {
                return newClient.size();
            }
        });

    }
}
