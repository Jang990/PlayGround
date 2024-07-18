package com.example.KafkaAndELK.product.v3.scheduler;

import com.example.KafkaAndELK.product.v3.ProductV3Repository;
import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import com.example.KafkaAndELK.product.v3.document.TagInfoV3;
import com.example.KafkaAndELK.product.v3.entity.ProductTagV3;
import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductTagSyncRepository {
    private final ProductV3Repository repository;

    public List<ProductInfoV3> findAll() {
        List<ProductV3> all = repository.findAllWithProductTag();
        return all.stream().map((product) -> new ProductInfoV3(
                product,
                hasTag(product) ? convertTags(product.getProductTagList()) : null
        )).toList();
    }

    private List<TagInfoV3> convertTags(List<ProductTagV3> productTagList) {
        return productTagList.stream()
                .map(pt -> new TagInfoV3(pt.getTag().getId(), pt.getTag().getTagName()))
                .toList();
    }

    private static boolean hasTag(ProductV3 product) {
        return product.getProductTagList() != null && !product.getProductTagList().isEmpty();
    }
}
