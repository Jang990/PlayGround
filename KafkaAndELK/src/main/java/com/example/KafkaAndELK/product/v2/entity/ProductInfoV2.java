package com.example.KafkaAndELK.product.v2.entity;

import com.example.KafkaAndELK.product.helper.Indices;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@Document(indexName = Indices.PRODUCT_V2_INDEX)
public class ProductInfoV2 {
    @Id
    private long id;
    private int price;
    private int stock;
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductInfoV2(ProductV2 productV2) {
        this.id = productV2.getId();
        this.price = productV2.getPrice();
        this.stock = productV2.getStock();
        this.name = productV2.getName();
        this.createdAt = productV2.getCreatedAt();
        this.updatedAt = productV2.getUpdatedAt();
    }
}
