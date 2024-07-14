package com.example.KafkaAndELK.product.v2.entity;

import com.example.KafkaAndELK.product.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ProductV2 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private int stock;
    private String name;

    public ProductV2(int price, int stock, String name) {
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public void buy() {
        stock--;
    }
}
