package com.es.similaritysearch.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDocumentRepository extends ElasticsearchRepository<MyDocument, Long> {
}
