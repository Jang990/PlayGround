package com.example.KafkaAndELK.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<ProductInfo, Long> {
    /*{
        "bool": {
            "must": [
              {"match": {"name": "?0"}}
            ]
        }
    }*/
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<ProductInfo> findProducts(String name, Pageable pageable);
}
