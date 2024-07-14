package com.example.KafkaAndELK.product.v1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ProductV1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private int stock;
    private String name;

    public ProductV1(int price, int stock, String name) {
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public void buy() {
        stock--;
    }
}
