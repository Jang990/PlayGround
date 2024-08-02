package com.tutorial.java.problem._2_369.step4;

public class ClapCounter {
    private int clapCount;

    public ClapCounter() {
        this.clapCount = 0;
    }

    public synchronized void increase(int cnt) {
        clapCount += cnt;
    }

    public int getClapCount() {
        return clapCount;
    }
}
