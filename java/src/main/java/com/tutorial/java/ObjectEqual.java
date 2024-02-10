package com.tutorial.java;

public class ObjectEqual {
    public static void main(String[] args) {
        Long wrapper = 1L;
        Long otherWrapper = 1L;
        System.out.println(wrapper == otherWrapper); // true

        /*
        자바에서는 Long에 대해 -127~128의 범위에서는 상수 풀을 유지한다.
        그렇기 때문에 이 범위내로 할당하게 되면 true를 확인할 수 있다.
         */

        Long wrapperOutOfCacheable1 = 1234L;
        Long wrapperOutOfCacheable2 = 1234L;
        System.out.println(wrapperOutOfCacheable1 == wrapperOutOfCacheable2); // false
        System.out.println(1234L == 1234L); // true 오토 언박싱


        long primitive1 = 1;
        long primitive2 = 1234;
        System.out.println(wrapper == primitive1); // true 오토 언박싱
        System.out.println(wrapperOutOfCacheable1 == primitive2); // true 오토 언박싱
    }
}