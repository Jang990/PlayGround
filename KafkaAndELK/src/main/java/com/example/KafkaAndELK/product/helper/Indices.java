package com.example.KafkaAndELK.product.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Indices {
    public static final String PRODUCT_V1_INDEX = "product_v1";
    public static final String PRODUCT_V2_INDEX = "product_v2";
    public static final String PRODUCT_V3_INDEX = "product_v3";
}
