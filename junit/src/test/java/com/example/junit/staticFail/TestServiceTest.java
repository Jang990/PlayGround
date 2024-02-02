package com.example.junit.staticFail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {
    @InjectMocks
    TestService testService;

    @Test
    void test() {
        testService.testEntity();
    }

}