package com.example.KafkaAndELK.product;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@Document(indexName = "product")
public class ProductInfo {
    @Id
    private long id;
    private int price;
    private int stock;
    private String name;

    public ProductInfo(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.name = product.getName();
    }
}
