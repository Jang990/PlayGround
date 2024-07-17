package com.example.KafkaAndELK.product.v3.tag;

import com.example.KafkaAndELK.product.v3.entity.ProductTagV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTagV3Repository extends JpaRepository<ProductTagV3, Long> {
    @Query("SELECT pt FROM ProductTagV3 pt WHERE pt.product.id = :productId AND pt.tag.id = :tagId")
    Optional<ProductTagV3> findProductTag(@Param("productId") long productId, long tagId);
}
