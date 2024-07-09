package com.example.KafkaAndELK.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private int stock;
    private String name;

    public Product(int price, int stock, String name) {
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public void buy() {
        stock--;
    }
}
