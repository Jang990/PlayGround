package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.ProductRequest;
import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * V2-JDBC.
 * 장점: 단순. 스케줄링에 따른 DB와의 동기화.
 * 단점: 스케줄링을 통해서 주기적으로 DB에 부하를 줌 - 데이터가 많아진 경우 부하도 커짐
 *      마지막 스케줄링 시간 이후의 update_at 필드값으로 가져오기 때문에
 *      제거는 따로 처리가 필요하거나 isDeleted 필드 추가가 필요함.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceV3 {
    private final ProductV3Repository repository;
    private final ProductSearchV3Repository searchRepository;

    public ProductV3 save(ProductRequest product) {
        ProductV3 result = new ProductV3(product.getPrice(), product.getStock(), product.getName());
        repository.save(result);
//        searchRepository.save(new ProductInfo(result)); // 이제 필요없어짐.
        return result;
    }

    public int purchase(long productId) {
        ProductV3 product = repository.findById(productId).orElseThrow(RuntimeException::new);
        product.buy();

        // 업데이트에 대한 처리가 필요없어짐

        return product.getStock();
    }

    public void delete(long productId) {
        repository.deleteById(productId);
        searchRepository.deleteById(productId); // isDeleted 필드가 따로 없다면 이렇게 수동 제거 필요.
    }
}
