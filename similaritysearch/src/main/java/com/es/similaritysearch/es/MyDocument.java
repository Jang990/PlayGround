package com.es.similaritysearch.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "my_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDocument {
    @Id
    private long id;

    private String content;

    @Field(type = FieldType.Dense_Vector, dims = 1536)
    private float[] embeddingVector;
}
