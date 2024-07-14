package com.example.KafkaAndELK.product;

import com.example.KafkaAndELK.product.v2.ProductSearchV2Repository;
import com.example.KafkaAndELK.product.v2.entity.ProductInfoV2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductSearchRepositoryTest {
    @Autowired
    ProductSearchV2Repository searchRepository;

    @Test
    void test() {
        List<ProductInfoV2> result = searchRepository.findProducts("신발", PageRequest.of(0, 100)).getContent();
        System.out.println(result.size());
        for (ProductInfoV2 productInfo : result) {
            System.out.println(productInfo);
        }
        System.out.println();

        System.out.println("전체");
        for (ProductInfoV2 productInfo : searchRepository.findAll()) {
            System.out.println(productInfo);
        }
    }

}