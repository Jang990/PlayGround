package com.example.KafkaAndELK.product.v1;

import com.example.KafkaAndELK.product.v1.entity.ProductV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductV1Repository extends JpaRepository<ProductV1, Long> {
}
