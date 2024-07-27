package com.example.KafkaAndELK.product;

import com.example.KafkaAndELK.product.v2.ProductSearchV2Repository;
import com.example.KafkaAndELK.product.v2.entity.ProductInfoV2;
import com.example.KafkaAndELK.product.v3.ProductSearchV3Repository;
import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import com.example.KafkaAndELK.product.v3.document.TagInfoV3;
import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class ProductSearchRepositoryTest {
    @Autowired
    ProductSearchV2Repository searchRepository;

    @Autowired
    ProductSearchV3Repository searchRepositoryV3;

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

    @Test
    void testV3() {
        System.out.println("전체");
//        for (ProductInfoV3 productInfo : searchRepositoryV3.findAll()) {
//            System.out.println(productInfo);
//        }

        long[] arr = {1, 3, 4, 5};
        for (long l : arr) {
            System.out.println(searchRepositoryV3.findById(l).get());
        }

        System.out.println(searchRepositoryV3.findById(2L).get());
    }

    @Test
    void saveTestV3() {
        ProductV3 jelly = new ProductV3(12L, 1002, 10, "하리보 젤리");
        List<TagInfoV3> list = List.of(new TagInfoV3(1L, "캔디류 aa"), new TagInfoV3(2L, "하리보"));
        ProductInfoV3 productInfo = new ProductInfoV3(jelly, list);
        searchRepositoryV3.save(productInfo);
    }

    @Test
    void v3SearchTest() {
        String productName = "하리보";
        String tagName = "캔디류";

        query("findWithName", searchRepositoryV3.findWithName(productName));
        query("findWithTagName", searchRepositoryV3.findWithTagName(tagName));
        query("findWithNameAndTagName", searchRepositoryV3.findWithNameAndTagName(productName, tagName));
    }

    private void query(String title, List<ProductInfoV3> searchRepositoryV3) {
        System.out.println(title);
        for (ProductInfoV3 productInfoV3 : searchRepositoryV3) {
            System.out.println(productInfoV3);
        }
        System.out.println();
    }

}