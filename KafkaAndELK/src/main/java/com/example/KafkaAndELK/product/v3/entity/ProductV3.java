package com.example.KafkaAndELK.product.v3.entity;

import com.example.KafkaAndELK.product.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class ProductV3 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private int stock;
    private String name;

    @OneToMany(mappedBy = "product")
    private List<ProductTagV3> productTagList;

    public ProductV3(int price, int stock, String name) {
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public ProductV3(long id, int price, int stock, String name) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public void buy() {
        stock--;
    }
}
