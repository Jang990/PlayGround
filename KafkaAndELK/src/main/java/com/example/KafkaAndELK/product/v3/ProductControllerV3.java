package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.ProductRequest;
import com.example.KafkaAndELK.product.v2.entity.ProductV2;
import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * V1. 애플리케이션 레벨에서 직접 ElasticSearch 색인 관리
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v3")
public class ProductControllerV3 {
    private final ProductServiceV3 productService;

    @PostMapping("/product")
    public ResponseEntity<ProductV3> save(@RequestBody ProductRequest product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PostMapping("/product/{id}/purchase")
    public ResponseEntity<Integer> purchase(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(productService.purchase(productId));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long productId) {
        productService.delete(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
