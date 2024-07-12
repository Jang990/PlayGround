package com.example.KafkaAndELK.product;

import com.example.KafkaAndELK.product.helper.Indices;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@Document(indexName = Indices.PRODUCT_INDEX)
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
