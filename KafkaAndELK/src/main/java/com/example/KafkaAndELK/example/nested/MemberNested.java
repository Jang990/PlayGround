package com.example.KafkaAndELK.example.nested;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberNested {
    private long id;
    private String name;
    private String role;
    private int age;
}
