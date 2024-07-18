package com.example.KafkaAndELK.product.v3.scheduler;

import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductTagRepositoryTest {
    @Autowired
    private ProductTagSyncRepository productTagSyncRepository;

    @Test
    void test() {
        for (ProductInfoV3 productInfoV3 : productTagSyncRepository.findAll()) {
            System.out.println(productInfoV3);
        }
    }

}