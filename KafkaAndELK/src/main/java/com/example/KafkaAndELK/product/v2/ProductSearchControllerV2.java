package com.example.KafkaAndELK.product.v2;

import com.example.KafkaAndELK.product.v2.entity.ProductInfoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2")
public class ProductSearchControllerV2 {
    private final ProductSearchV2Repository repository;
    private final Pageable pageable = PageRequest.of(0, 100);

    @GetMapping("/product")
    public ResponseEntity<List<ProductInfoV2>> findAllProduct(String name) {
        Page<ProductInfoV2> list;
        if(name == null || name.isEmpty())
            list = repository.findAll(pageable);
        else
            list = repository.findProducts(name, pageable);
        return ResponseEntity.ok(list.getContent());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductInfoV2> findAllProduct(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(
                repository.findById(productId)
                        .orElse(null)
        );
    }
}
