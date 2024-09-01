package com.tutorial.java.portfolio.batch;

import com.tutorial.java.portfolio.batch.entity.IdentityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Portfolio_JDBCTemplate {
    private final JdbcTemplate template;

    @Transactional
    public void saveBulkSomething(List<IdentityEntity> newClient) {
        final String insertSQL = "INSERT INTO " +
                "test_entity (something) " +
                "VALUES(?)";

        template.batchUpdate(insertSQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                IdentityEntity client = newClient.get(i);
                ps.setInt(1, client.getSomething());
            }

            @Override
            public int getBatchSize() {
                return newClient.size();
            }
        });

    }
}
