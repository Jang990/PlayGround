package com.tutorial.java.portfolio.batch;

import com.tutorial.java.portfolio.SequenceRepository;
import com.tutorial.java.portfolio.batch.entity.IdentityEntity;
import com.tutorial.java.portfolio.batch.entity.SequenceEntity;
import jakarta.persistence.EntityManager;
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

    @Autowired
    EntityManager em;

    private static List<SequenceEntity> entity() {
        return IntStream.range(0, 5)
                .mapToObj(SequenceEntity::new)
                .toList();
    }

    @Test
    @Transactional
    void test2() {
        List<SequenceEntity> list = entity();

        /*
        Hibernate:
            select next_val as id_val from sequence_entity_seq for update
        Hibernate:
            update sequence_entity_seq set next_val= ? where next_val=?

        시퀀스는 쓰기 지연이 적용가능하므로 바로 insert 쿼리가 나가지 않는다.
         */
        repository.saveAll(list);

        // 테스트는 롤백이 되므로 직접 flush를 호출해주어야 insert 쿼리를 확인할 수 있다.
        System.out.println("명시적 플러시!");
        em.flush();
        em.clear();
        /*
        명시적 플러시!

        Hibernate:
            (주석)insert for com.tutorial.java.portfolio.batch.entity.SequenceEntity
            insert into sequence_entity (something, id) values (?, ?)
        Hibernate:
            (주석)insert for com.tutorial.java.portfolio.batch.entity.SequenceEntity
            insert into sequence_entity (something, id) values (?, ?)
        ... 반복
         */
        /*
        spring 로그에는 각각의 insert로 나가는 것으로 보이지만 DB로그는 batch insert를 해주고 있다.
         db로그
        select next_val as id_val from sequence_entity_seq for update
        update sequence_entity_seq set next_val= 351 where next_val=301
        insert into sequence_entity (something,id) values (0,252),(1,253),(2,254),(3,255),(4,256)

        다시 시도 - 시퀀스 증가값은 기본 allocationSize인 50 증가가 적용된 듯 보인다.
         db 로그
        select next_val as id_val from sequence_entity_seq for update
        update sequence_entity_seq set next_val= 351 where next_val=301
        insert into sequence_entity (something,id) values (0,302),(1,303),(2,304),(3,305),(4,306)
         */
    }

}