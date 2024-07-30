package com.tutorial.java.conc;

import com.tutorial.java.conc.obj.BasicObj;
import com.tutorial.java.conc.obj.LockObj;
import com.tutorial.java.conc.obj.SynchronizedObj;
import com.tutorial.java.conc.obj.TestObj;
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
