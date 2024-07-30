package com.tutorial.java.conc;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class ConcurrencyIssueHelper {

    private static final int LOOP_CNT = 10000;
    private static final int READ_THREAD_CNT = 0;
    private static final int WRITE_THREAD_CNT = 2;

    public static void test(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static Thread create(IntSupplier getter) {
        Runnable runnable = () -> {
            for (int i = 0; i < LOOP_CNT; i++) {
                System.out.println(getter.getAsInt());
            }
        };
        return new Thread(runnable);
    }

    public static Thread create(Runnable increase) {
        Runnable runnable = () -> {
            for (int i = 0; i < LOOP_CNT; i++) {
                increase.run();
            }
        };
        return new Thread(runnable);
    }

    public static void sleep(long time) {
        try {
            Thread.sleep((long) (time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
