package com.tutorial.java.problem._369.step4;

public class ClapCounter {
    private int clapCount;

    public ClapCounter() {
        this.clapCount = 0;
    }

    public int getClapCount() {
        return clapCount;
    }

    public synchronized void increase(int count) {
        clapCount += count;
    }
}
