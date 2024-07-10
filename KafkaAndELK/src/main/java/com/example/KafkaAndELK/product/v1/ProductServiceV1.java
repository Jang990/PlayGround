package com.example.KafkaAndELK.product.v1;

import com.example.KafkaAndELK.product.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * V1. 애플리케이션 레벨에서 직접 ElasticSearch 색인 관리
 * 장점: 단순
 * 단점: 트랜잭션 처리가 애매
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceV1 {
    private final ProductRepository repository;
    private final ProductSearchRepository searchRepository;

    public Product save(ProductRequest product) {
        Product result = new Product(product.getPrice(), product.getStock(), product.getName());
        save(result);
        return result;
    }

    public int purchase(long productId) {
        Product product = repository.findById(productId).orElseThrow(RuntimeException::new);
        product.buy();

        update(productId, product);
        return product.getStock();
    }

    public void delete(long productId) {
        repository.deleteById(productId);
        searchRepository.deleteById(productId);
    }

    private void save(Product result) {
        repository.save(result);
        searchRepository.save(new ProductInfo(result));
    }

    private void update(long productId, Product product) {
        searchRepository.deleteById(productId);
        searchRepository.save(new ProductInfo(product));
    }
}
