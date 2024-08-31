package com.tutorial.java.portfolio;

import com.tutorial.java.portfolio.timeout.TestRepository;
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
public class Portfolio_Jpa {
    private final TestRepository repository;

    @Transactional
    public void saveBulkSomething(List<TestEntity> newClient) {
        repository.saveAll(newClient);
    }
}
