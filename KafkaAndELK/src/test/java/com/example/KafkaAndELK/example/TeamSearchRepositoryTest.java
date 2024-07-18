package com.example.KafkaAndELK.example;

import com.example.KafkaAndELK.example.nested.MemberNested;
import com.example.KafkaAndELK.example.nested.TeamNested;
import com.example.KafkaAndELK.example.obj.MemberObj;
import com.example.KafkaAndELK.example.obj.TeamObj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ES Object Field와 Nested Field 비교
 */
@SpringBootTest
class TeamSearchRepositoryTest {
    @Autowired TeamNestedSearchRepository nestedSearchRepository;
    @Autowired TeamObjSearchRepository objSearchRepository;

    final String MANAGER = "MANAGER";
    final String ENGINEER = "ENGINEER";

    @BeforeEach
    void beforeEach() {
        List<TeamObj> objTeams = List.of(
                new TeamObj(1L, "회계팀", List.of(new MemberObj(1L, "김현우",MANAGER, 54))),
                new TeamObj(2L, "개발팀",
                        List.of(
                                new MemberObj(2L, "김진수", MANAGER, 42),
                                new MemberObj(3L, "김현우", ENGINEER, 24)
                        )
                ),
                new TeamObj(3L, "인사팀", List.of(new MemberObj(4L, "김민수", MANAGER, 57)))
        );
        objSearchRepository.saveAll(objTeams);

        List<TeamNested> nestedTeams = List.of(
                new TeamNested(1L, "회계팀", List.of(new MemberNested(1L, "김현우", MANAGER, 54))),
                new TeamNested(2L, "개발팀",
                        List.of(
                                new MemberNested(2L, "김진수", MANAGER, 42),
                                new MemberNested(3L, "김현우", ENGINEER, 24)
                        )
                ),
                new TeamNested(3L, "인사팀", List.of(new MemberNested(4L, "김인사", MANAGER, 57)))
        );
        nestedSearchRepository.saveAll(nestedTeams);
    }

    @Test
    void test1() {
        System.out.println("팀 obj");
        for (TeamObj teamObj : objSearchRepository.findAll()) {
            System.out.println(teamObj);
        }

        System.out.println("\n팀 nested");
        for (TeamNested teamNested : nestedSearchRepository.findAll()) {
            System.out.println(teamNested);
        }
    }

    @Test
    void test2() {
        String searchingName = "김현우";
        String searchingRole = MANAGER;

        /*
        TeamObj(id=1, name=회계팀, members=[MemberObj(id=1, name=김현우, role=MANAGER, age=54)])
        TeamObj(id=2, name=개발팀, members=[MemberObj(id=2, name=김진수, role=MANAGER, age=42), MemberObj(id=3, name=김현우, role=ENGINEER, age=24)])
         */
        System.out.println("팀 obj");
        for (TeamObj teamObj : objSearchRepository.searchTeam(searchingName, searchingRole)) {
            System.out.println(teamObj);
        }
        System.out.println();

        /* 나오는 결과가 없음. */
        query("팀 nested", nestedSearchRepository.searchTeam(searchingName, searchingRole));

        /* TeamNested(id=1, name=회계팀, members=[MemberNested(id=1, name=김현우, role=MANAGER, age=54)]) */
        query("팀 nested - nested 쿼리", nestedSearchRepository.searchNested(searchingName, searchingRole));
    }

    private void query(String log, List<TeamNested> nestedSearchRepository) {
        System.out.println(log);
        for (TeamNested teamNested : nestedSearchRepository) {
            System.out.println(teamNested);
        }
        System.out.println();
    }
}