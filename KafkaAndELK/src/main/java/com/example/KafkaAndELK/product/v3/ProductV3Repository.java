package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductV3Repository extends JpaRepository<ProductV3, Long> {
    @Query("""
            SELECT p FROM ProductV3 p
            LEFT JOIN FETCH p.productTagList
            """)
    List<ProductV3> findAllWithProductTag();
}
