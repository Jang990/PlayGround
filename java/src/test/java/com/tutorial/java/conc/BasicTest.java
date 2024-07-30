package com.tutorial.java.conc;

import org.junit.jupiter.api.Test;

public class BasicTest {


    @Test
    void test() throws InterruptedException {
        BasicObj testObj = new BasicObj();

        Thread[] threads = new Thread[2];
        threads[0] = ConcurrencyIssueHelper.create(testObj::increase);
        threads[1] = ConcurrencyIssueHelper.create(testObj::increase);


        ConcurrencyIssueHelper.test(threads);
        System.out.println(testObj.getValue()); // 원한 값 : 20000 , 실제 결과 : 11940
    }

    static class BasicObj {
        private int value = 0;

        public int getValue() {
            return value;
        }

        public void increase() {
            value++;
        }
    }
}
