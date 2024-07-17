package com.example.KafkaAndELK.product.v3.document;

import com.example.KafkaAndELK.product.helper.Indices;
import com.example.KafkaAndELK.product.v3.entity.ProductV3;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@Document(indexName = Indices.PRODUCT_V3_INDEX)
public class ProductInfoV3 {
    @Id
    private long id;
    private int price;
    private int stock;
    private String name;

    @Field(type = FieldType.Nested)
    private List<TagInfoV3> tagInfoV3;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductInfoV3(ProductV3 productV3, List<TagInfoV3> tagInfoV3) {
        this.id = productV3.getId();
        this.price = productV3.getPrice();
        this.stock = productV3.getStock();
        this.name = productV3.getName();
        this.createdAt = productV3.getCreatedAt();
        this.updatedAt = productV3.getUpdatedAt();
        this.tagInfoV3 = tagInfoV3;
    }
}
