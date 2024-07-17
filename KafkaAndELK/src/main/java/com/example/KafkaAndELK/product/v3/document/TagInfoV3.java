package com.example.KafkaAndELK.product.v3.document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@NoArgsConstructor
public class TagInfoV3 {
    @Id
    private long id;
    private String tagName;

    public TagInfoV3(long id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }
}
