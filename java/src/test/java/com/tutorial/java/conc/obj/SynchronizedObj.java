package com.tutorial.java.conc.obj;

public class SynchronizedObj implements TestObj {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public synchronized void increase() {
            value++;
        }
}