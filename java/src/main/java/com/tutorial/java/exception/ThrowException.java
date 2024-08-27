package com.tutorial.java.exception;

import java.sql.SQLException;

public class ThrowException {
    public static void main(String[] args) {
//        throw new SQLException(); // 체크
//        throw new RuntimeException();
//        throw new Error(); // 언체크드
        Integer n1 = 10_000_000;
        Integer n2 = 2_000_000;
        System.out.println(n1 > n2);
    }

}
