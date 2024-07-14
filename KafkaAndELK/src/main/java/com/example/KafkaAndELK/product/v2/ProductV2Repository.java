package com.example.KafkaAndELK.product.v2;

import com.example.KafkaAndELK.product.v2.entity.ProductV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductV2Repository extends JpaRepository<ProductV2, Long> {
}
