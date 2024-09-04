package com.tutorial.java.portfolio.batch;

import com.tutorial.java.portfolio.SequenceRepository;
import com.tutorial.java.portfolio.batch.entity.IdentityEntity;
import com.tutorial.java.portfolio.batch.entity.SequenceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class SequenceEntityTest {

    @Autowired
    SequenceRepository repository;

    private static List<SequenceEntity> entity() {
        return IntStream.range(0, 5)
                .mapToObj((n) -> new SequenceEntity(n))
                .toList();
    }

    @Test
    @Transactional
    void test2() {
        List<SequenceEntity> list = entity();
        /*
        Hibernate:
            insert into test_entity (something) values (?)
        Hibernate:
            insert into test_entity (something) values (?)
        ...
         */
        repository.saveAll(list);
    }

}