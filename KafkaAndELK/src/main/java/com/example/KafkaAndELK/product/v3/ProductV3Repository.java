package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductV3Repository extends JpaRepository<ProductV3, Long> {
}
