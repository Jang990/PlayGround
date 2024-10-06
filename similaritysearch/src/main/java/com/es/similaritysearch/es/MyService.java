package com.es.similaritysearch.es;

import co.elastic.clients.elasticsearch._types.KnnQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyService {
    private final EmbeddingModel embeddingModel;
    private final MyDocumentRepository repository;

    private final ElasticsearchOperations operations;

    public void save(long id, String content) {
        MyDocument doc = repository.save(new MyDocument(id, content, embedList(content)));
        System.out.println(doc);
    }

//    public List<MyDocument> service(String answer) {
//        return repository.similar(embed(answer));
//    }

    public List<MyDocument> searchSimilarityContent(String answer) {
        SearchHits<MyDocument> hits = search(answer);

        List<MyDocument> result = new LinkedList<>();
        for (SearchHit<MyDocument> myDocumentSearchHit : hits)
            result.add(myDocumentSearchHit.getContent());
        return result;
    }

    private SearchHits<MyDocument> search(String answer) {
        KnnQuery knn = new KnnQuery.Builder()
                .field("embeddingVector")
                .queryVector(embedList(answer))
                .numCandidates(100L)
                .build();

        NativeQuery query = new NativeQueryBuilder()
                .withKnnQuery(knn)
                .build();

        System.out.println(query.getMaxResults());

        return operations.search(query, MyDocument.class);
    }

    private List<Float> convertList(float[] arr) {
        List<Float> result = new LinkedList<>();
        for (float v : arr) {
            result.add(v);
        }
        return result;
    }

    private List<Float> embedList(String content) {
        return convertList(embed(content));
    }

    private float[] embed(String content) {
        return embeddingModel.embed(content);
    }
}
