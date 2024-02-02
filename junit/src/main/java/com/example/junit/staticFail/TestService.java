package com.example.junit.staticFail;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public void testEntity() {
        System.out.println("TestService.testEntity");
        TestEntity testEntity = new TestEntity();
        testEntity.raiseEvent();
    }
}
