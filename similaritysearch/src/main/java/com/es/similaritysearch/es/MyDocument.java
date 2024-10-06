package com.es.similaritysearch.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.LinkedList;
import java.util.List;

@Document(indexName = "my_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDocument {
    @Id
    private long id;

    private String content;

    @Field(type = FieldType.Dense_Vector, dims = 1536, index = true, similarity = "dot_product")
    private List<Float> embeddingVector = new LinkedList<>();
}
