package com.example.KafkaAndELK.example.obj;

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
@Document(indexName = Indices.TEAM_OBJ_INDEX)
public class TeamObj {
    @Id
    private long id;
    private String name;

    @Field(type = FieldType.Object)
    private List<MemberObj> members;
}
