package com.es.similaritysearch.es;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyDocumentRepository extends ElasticsearchRepository<MyDocument, Long> {
}
