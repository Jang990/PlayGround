package com.example.KafkaAndELK.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository repository;
    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAllProduct() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findAllProduct(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(repository.findById(productId).orElseThrow(IllegalArgumentException::new));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody ProductRequest product) {
        Product result = new Product(product.getPrice(), product.getStock(), product.getName());
        return new ResponseEntity<>(repository.save(result), HttpStatus.CREATED);
    }

    @PostMapping("/product/{id}/purchase")
    public ResponseEntity<Integer> purchase(@PathVariable(name = "id") long productId) {
        Product product = repository.findById(productId).orElseThrow(RuntimeException::new);
        product.buy();
        return ResponseEntity.ok(product.getStock());
    }
}
