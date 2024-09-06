package com.tutorial.java.portfolio.batch.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SequenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int something;

    public SequenceEntity(int something) {
        this.something = something;
    }
}
