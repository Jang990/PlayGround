package com.example.KafkaAndELK.product.v1;

import com.example.KafkaAndELK.product.v1.entity.ProductInfoV1;
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
@RequestMapping("/v1")
public class ProductSearchControllerV1 {
    private final ProductSearchV1Repository repository;
    private final Pageable pageable = PageRequest.of(0, 100);

    @GetMapping("/product")
    public ResponseEntity<List<ProductInfoV1>> findAllProduct(String name) {
        Page<ProductInfoV1> list;
        if(name == null || name.isEmpty())
            list = repository.findAll(pageable);
        else
            list = repository.findProducts(name, pageable);
        return ResponseEntity.ok(list.getContent());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductInfoV1> findAllProduct(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(
                repository.findById(productId)
                        .orElse(null)
        );
    }
}
