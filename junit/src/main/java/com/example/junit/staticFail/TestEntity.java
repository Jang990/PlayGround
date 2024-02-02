package com.example.junit.staticFail;

import com.example.junit.staticFail.event.Events;
import com.example.junit.staticFail.event.TestEvent;

public class TestEntity {
    public void raiseEvent() {
        System.out.println("TestEntity.raiseEvent");
        Events.raise(new TestEvent());
    }
}
