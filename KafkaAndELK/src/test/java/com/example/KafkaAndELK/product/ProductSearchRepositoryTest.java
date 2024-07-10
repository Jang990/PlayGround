package com.example.KafkaAndELK.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductSearchRepositoryTest {
    @Autowired
    ProductSearchRepository searchRepository;

    @Test
    void test() {
        List<ProductInfo> result = searchRepository.findProducts("신발", PageRequest.of(0, 100)).getContent();
        System.out.println(result.size());
        for (ProductInfo productInfo : result) {
            System.out.println(productInfo);
        }
        System.out.println();

        System.out.println("전체");
        for (ProductInfo productInfo : searchRepository.findAll()) {
            System.out.println(productInfo);
        }
    }

}