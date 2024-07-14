package com.example.KafkaAndELK.product.v1;

import com.example.KafkaAndELK.product.v1.entity.ProductInfoV1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchV1Repository extends ElasticsearchRepository<ProductInfoV1, Long> {
    /*{
        "bool": {
            "must": [
              {"match": {"name": "?0"}}
            ]
        }
    }*/
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<ProductInfoV1> findProducts(String name, Pageable pageable);
}
