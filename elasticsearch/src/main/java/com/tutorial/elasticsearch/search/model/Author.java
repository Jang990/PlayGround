package com.tutorial.elasticsearch.search.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@ToString
@AllArgsConstructor
public class Author {
    @Field(type = FieldType.Text)
    private String name;
}
