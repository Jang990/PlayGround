package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchV3Repository extends ElasticsearchRepository<ProductInfoV3, Long> {
    @Query("""
            {
                "bool": {
                    "must": [ {"match": {"name": "?0"}} ]
                }
            }
            """)
    List<ProductInfoV3> findWithName(String name);

    @Query("""
            {
                "nested": {
                    "path": "tag_info_v3",
                    "query": {
                        "bool": { "must": [{"match": {"tag_info_v3.tag_name": "?0"}} ] }
                    }
                }
            }
            """)
    List<ProductInfoV3> findWithTagName(String tagName);

    @Query("""
            {
                "bool": {
                        "must": [
                            {
                                "bool": {
                                    "must": [ {"match": {"name": "?0"}} ]
                                }
                            },
                            {
                                "nested": {
                                    "path": "tag_info_v3",
                                    "query": {
                                        "bool": { "must": [{"match": {"tag_info_v3.tag_name": "?1"}} ] }
                                    }
                                }
                            }
                        ]
                    }
            }
            """)
    List<ProductInfoV3> findWithNameAndTagName(String name, String tagName);
}
