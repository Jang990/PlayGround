package com.example.junit.staticFail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtherTestService {
    private final TestService service;

    public void test() {
        System.out.println("OtherTestService.test");
        service.testEntity();
    }
}
