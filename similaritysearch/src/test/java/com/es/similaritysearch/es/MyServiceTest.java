package com.es.similaritysearch.es;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyServiceTest {
    @Autowired MyService myService;
    @Autowired MyDocumentRepository repository;

    List<String> questions = List.of(
            "Spring의 특징이 뭔가요?",
            "Spring Bean의 라이프사이클을 설명해주세요.",
            "DI와 IoC가 뭔지 설명해주시고, 이로 인해 얻을 수 있는 장점을 말해주세요."
    );


    @Test
    void test() {
        for (int i = 0; i < questions.size(); i++) {
            myService.save(i, questions.get(i));
        }
    }

    @Test
    void test2() {
        List<MyDocument> myDocuments = myService.searchSimilarityContent("DI와 IoC입니다.");
        System.out.println(myDocuments);
    }

    @Test
    void test3() {
        List<MyDocument> myDocuments = myService.searchSimilarityContent("잘 모르겠습니다.");
        System.out.println(myDocuments);
    }

//    @Test
//    void test4() {
//        List<MyDocument> result = myService.service("DI와 IoC입니다.");
//        System.out.println(result);
//    }

}