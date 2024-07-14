package com.example.KafkaAndELK.product.v2;

import com.example.KafkaAndELK.product.v2.entity.ProductInfoV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchV2Repository extends ElasticsearchRepository<ProductInfoV2, Long> {
    /*{
        "bool": {
            "must": [
              {"match": {"name": "?0"}}
            ]
        }
    }*/
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<ProductInfoV2> findProducts(String name, Pageable pageable);
}
