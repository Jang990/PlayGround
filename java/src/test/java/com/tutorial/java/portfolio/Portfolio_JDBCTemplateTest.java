package com.tutorial.java.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Portfolio_JDBCTemplateTest {
    @Autowired
    Portfolio_JDBCTemplate jdbc;

    @Test
    @Transactional
    void test() {
        /*
        INSERT INTO test_entity (something) VALUES(0);
        INSERT INTO test_entity (something) VALUES(1);
        INSERT INTO test_entity (something) VALUES(2);
        INSERT INTO test_entity (something) VALUES(3);
        INSERT INTO test_entity (something) VALUES(4);
         */
        List<TestEntity> list = IntStream.range(0, 5)
                .mapToObj((n) -> new TestEntity(n))
                .toList();

        jdbc.saveBulkSomething(list);
        System.out.println(" ===== ");
        jdbc.saveBulkSomething(list);
    }

}