package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchV3Repository extends ElasticsearchRepository<ProductInfoV3, Long> {
    /*{
        "bool": {
            "must": [
              {"match": {"name": "?0"}}
            ]
        }
    }*/
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<ProductInfoV3> findProducts(String name, Pageable pageable);
}
