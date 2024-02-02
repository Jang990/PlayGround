package com.example.junit.staticFail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OtherTestServiceTest {

    @Autowired
    OtherTestService testService;

    @Test
    void test() {
        testService.test();
    }
}