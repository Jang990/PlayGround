package com.example.KafkaAndELK.product.v3;

import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v3")
public class ProductSearchControllerV3 {
    private final ProductSearchV3Repository repository;
    private final Pageable pageable = PageRequest.of(0, 100);

    @GetMapping("/product")
    public ResponseEntity<List<ProductInfoV3>> findAllProduct(String name, String tagName) {
        List<ProductInfoV3> list;
        boolean hasProductName = StringUtils.hasText(name);
        boolean hasTagName = StringUtils.hasText(tagName);

        if(hasProductName && hasTagName)
            list = repository.findWithNameAndTagName(name, tagName);
        else if(hasProductName)
            list = repository.findWithName(name);
        else if(hasTagName)
            list = repository.findWithTagName(tagName);
        else
            list = repository.findAll(pageable).getContent();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductInfoV3> findAllProduct(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(
                repository.findById(productId)
                        .orElse(null)
        );
    }
}
