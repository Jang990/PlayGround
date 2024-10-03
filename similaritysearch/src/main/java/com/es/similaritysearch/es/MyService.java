package com.es.similaritysearch.es;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {
    private final EmbeddingModel embeddingModel;
    private final MyDocumentRepository repository;

    public void save(long id, String content) {
        MyDocument doc = repository.save(new MyDocument(id, content, embeddingModel.embed(content)));
        System.out.println(doc);
    }
}
