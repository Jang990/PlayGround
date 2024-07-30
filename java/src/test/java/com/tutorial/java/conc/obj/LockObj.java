package com.tutorial.java.conc.obj;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockObj implements TestObj {
    private int value = 0;
    private Lock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    public void increase() {
        lock.lock();
        value++;
        lock.unlock();
    }
}
