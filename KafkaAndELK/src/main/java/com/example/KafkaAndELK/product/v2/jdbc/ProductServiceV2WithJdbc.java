package com.example.KafkaAndELK.product.v2.jdbc;

import com.example.KafkaAndELK.product.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * V2-JDBC. 애플리케이션 레벨에서 직접 ElasticSearch 색인 관리
 * 장점: 단순
 * 단점: 실시간 동기화가 안됨. logstash의 스케줄에 따르게 됨.
 *      마지막 스케줄링 시간 이후의 update_at 필드값으로 가져오기 때문에
 *      제거는 따로 처리가 필요하거나 isDeleted 필드 추가가 필요함.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceV2WithJdbc {
    private final ProductRepository repository;
    private final ProductSearchRepository searchRepository;

    public Product save(ProductRequest product) {
        Product result = new Product(product.getPrice(), product.getStock(), product.getName());
        repository.save(result);
//        searchRepository.save(new ProductInfo(result)); // 이제 필요없어짐.
        return result;
    }

    public int purchase(long productId) {
        Product product = repository.findById(productId).orElseThrow(RuntimeException::new);
        product.buy();

        // 업데이트에 대한 처리가 필요없어짐

        return product.getStock();
    }

    public void delete(long productId) {
        repository.deleteById(productId);
        searchRepository.deleteById(productId); // isDeleted 필드가 따로 없다면 이렇게 수동 제거 필요.
    }
}
