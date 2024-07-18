package com.example.KafkaAndELK.example.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Indices {
    public static final String TEAM_OBJ_INDEX = "team_obj";
    public static final String TEAM_NESTED_INDEX = "team_nested";
}
