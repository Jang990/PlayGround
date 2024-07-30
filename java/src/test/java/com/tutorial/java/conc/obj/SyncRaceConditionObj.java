package com.tutorial.java.conc.obj;

import com.tutorial.java.conc.ConcurrencyIssueHelper;

public class SyncRaceConditionObj implements TestObj {
    private int value = 0;

    public synchronized int getValue() {
        System.out.println("getValue");
        ConcurrencyIssueHelper.sleep(3000);
        return value;
    }

    public synchronized void increase() {
        System.out.println("increase");
        ConcurrencyIssueHelper.sleep(3000);
        value++;
    }

    public static synchronized void test() {
        System.out.println("Test For Sync");
        ConcurrencyIssueHelper.sleep(3000);
    }
}
