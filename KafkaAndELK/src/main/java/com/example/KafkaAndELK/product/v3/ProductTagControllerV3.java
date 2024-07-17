package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.v3.entity.ProductTagV3;
import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import com.example.KafkaAndELK.product.v3.entity.TagV3;
import com.example.KafkaAndELK.product.v3.tag.ProductTagV3Repository;
import com.example.KafkaAndELK.product.v3.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Transactional
@RestController
@RequestMapping("/v3")
@RequiredArgsConstructor
public class ProductTagControllerV3 {
    private final TagRepository tagRepository;
    private final ProductV3Repository productRepository;
    private final ProductTagV3Repository productTagRepository;
    @PostMapping("/product/{productId}/tag")
    public ResponseEntity<ProductTagV3> connectTag(
            @PathVariable("productId") long productId,
            @RequestBody Map<String, String> map
    ) {
        ProductV3 product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
        TagV3 tag = tagRepository.findById(Long.parseLong(map.get("tagId"))).orElseThrow(IllegalArgumentException::new);
        ProductTagV3 productTag = new ProductTagV3(product, tag);
        return new ResponseEntity<>(productTagRepository.save(productTag), HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{productId}/tag")
    @Transactional
    public ResponseEntity<ProductTagV3> disconnectTag(
            @PathVariable("productId") long productId,
            @PathVariable("tagId") long tagId
    ) {
        ProductTagV3 productTag = productTagRepository.findProductTag(productId, tagId).orElseThrow(IllegalArgumentException::new);
        productTagRepository.delete(productTag);

        return ResponseEntity.noContent().build();
    }
}
