package com.example.KafkaAndELK.example.nested;

import com.example.KafkaAndELK.example.helper.Indices;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = Indices.TEAM_NESTED_INDEX)
public class TeamNested {
    @Id
    private long id;
    private String name;

    @Field(type = FieldType.Nested)
    private List<MemberNested> members;
}
