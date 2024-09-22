package com.example.KafkaAndELK.question;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface QuestionSearchRepository extends ElasticsearchRepository<QuestionDocument, Long> {
}
