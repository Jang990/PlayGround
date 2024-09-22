package com.example.KafkaAndELK.question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@ToString
@NoArgsConstructor
@Document(indexName = Indices.QUESTION_INDEX)
public class QuestionDocument {
    @Id
    private long id;
    private String content;

    public QuestionDocument(Question question) {
        this.id = question.getId();
        this.content = question.getContent();
    }
}
