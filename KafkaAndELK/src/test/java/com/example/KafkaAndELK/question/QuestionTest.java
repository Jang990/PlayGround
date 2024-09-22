package com.example.KafkaAndELK.question;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class QuestionTest {
    @Autowired QuestionRepository repository;
    @Autowired QuestionSearchRepository searchRepository;
    private List<Question> data = List.of(
            new Question("DI와 IoC에 대해서 자세하게 설명해주시고 OCP에 대해 추가적으로 설명해주세요."),
            new Question("R 트리가 무엇인지 알고 있나요?"),
            new Question("DB의 인덱스란 무엇인가요?"),
            new Question("격리수준에 대해 알고 계신가요?")
    );
    private List<QuestionDocument> docs;

    @BeforeEach
    void beforeEach() {
        repository.saveAll(data);

        docs = data.stream().map(QuestionDocument::new).toList();
        searchRepository.saveAll(docs);
    }

    @AfterEach
    void afterEach() {
        docs.forEach(doc -> searchRepository.deleteById(doc.getId()));
    }

    @Test
    void findAll() {
        searchRepository.findAll().forEach(System.out::println);
    }

}