package com.example.KafkaAndELK.product.v1;

import com.example.KafkaAndELK.product.*;
import com.example.KafkaAndELK.product.helper.Indices;
import com.example.KafkaAndELK.product.v1.entity.ProductInfoV1;
import com.example.KafkaAndELK.product.v1.entity.ProductV1;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * V1. 애플리케이션 레벨에서 직접 ElasticSearch 색인 관리
 * 장점: 단순
 * 단점: 트랜잭션 처리가 애매
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceV1 {
    private final ProductV1Repository repository;
    private final ProductSearchV1Repository searchRepository;
    private final ElasticsearchTemplate elasticsearchTemplate;

    public ProductV1 save(ProductRequest product) {
        ProductV1 result = new ProductV1(product.getPrice(), product.getStock(), product.getName());
        save(result);
        return result;
    }

    public int purchase(long productId) {
        ProductV1 product = repository.findById(productId).orElseThrow(RuntimeException::new);
        product.buy();

        UpdateQuery updateQuery = UpdateQuery.builder(Long.toString(productId))
                .withDocument(Document.from(Map.of("stock", product.getStock())))
                .build();
        elasticsearchTemplate.update(updateQuery, IndexCoordinates.of(Indices.PRODUCT_V1_INDEX));
        return product.getStock();
    }

    public void delete(long productId) {
        repository.deleteById(productId);
        searchRepository.deleteById(productId);
    }

    private void save(ProductV1 result) {
        repository.save(result);
        searchRepository.save(new ProductInfoV1(result));
    }
}
