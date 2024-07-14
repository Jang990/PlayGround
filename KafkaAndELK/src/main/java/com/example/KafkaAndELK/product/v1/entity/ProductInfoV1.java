package com.example.KafkaAndELK.product.v1.entity;

import com.example.KafkaAndELK.product.helper.Indices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@ToString
@NoArgsConstructor
@Document(indexName = Indices.PRODUCT_V1_INDEX)
public class ProductInfoV1 {
    @Id
    private long id;
    private int price;
    private int stock;
    private String name;

    public ProductInfoV1(ProductV1 productV1) {
        this.id = productV1.getId();
        this.price = productV1.getPrice();
        this.stock = productV1.getStock();
        this.name = productV1.getName();
    }
}
