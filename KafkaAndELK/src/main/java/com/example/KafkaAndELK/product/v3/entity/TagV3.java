package com.example.KafkaAndELK.product.v3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class TagV3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String tagName;

    public TagV3(String tagName) {
        this.tagName = tagName;
    }
}
