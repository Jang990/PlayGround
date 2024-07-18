package com.example.KafkaAndELK.example.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberObj {
    private long id;
    private String name;
    private String role;
    private int age;
}
