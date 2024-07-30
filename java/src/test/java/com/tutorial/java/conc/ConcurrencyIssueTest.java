package com.tutorial.java.conc;

import com.tutorial.java.conc.obj.*;
import org.junit.jupiter.api.Test;

public class ConcurrencyIssueTest {

    @Test
    void testMiss() {
        testSync(new BasicObj()); // 원한 값 : 20000 , 실제 결과 : 11940
    }
    @Test
    void test() {
        testSync(new SynchronizedObj()); // 원한 값 : 20000 , 실제 결과 : 20000
    }

    @Test
    void test2() {
        testSync(new LockObj()); // 원한 값 : 20000 , 실제 결과 : 20000
    }

    @Test
    void syncTest() throws InterruptedException {
        SyncRaceConditionObj raceObj = new SyncRaceConditionObj();
        Thread t1 = new Thread(raceObj::getValue);
        Thread t2 = new Thread(raceObj::increase);
        Thread staticT1 = new Thread(SyncRaceConditionObj::test);
        Thread staticT2 = new Thread(SyncRaceConditionObj::test);

        t1.start();
        t2.start();
        staticT1.start();
        staticT2.start();

        t1.join();
        t2.join();
        staticT1.join();
        staticT2.join();
    }

    private static void testSync(TestObj testObj) {
        Thread[] threads = new Thread[2];
        threads[0] = ConcurrencyIssueHelper.create(testObj::increase);
        threads[1] = ConcurrencyIssueHelper.create(testObj::increase);


        try {
            ConcurrencyIssueHelper.test(threads);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(testObj.getClass().getName() + " : " + testObj.getValue());
    }


}
