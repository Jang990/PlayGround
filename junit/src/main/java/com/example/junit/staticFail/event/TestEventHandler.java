package com.example.junit.staticFail.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TestEventHandler {
    @EventListener(TestEvent.class)
    public void handle(TestEvent event) {
        System.out.println("TestEventHandler.handle");
    }
}
