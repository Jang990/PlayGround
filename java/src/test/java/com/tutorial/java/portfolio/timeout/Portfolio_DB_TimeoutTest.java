package com.tutorial.java.portfolio.timeout;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Portfolio_DB_TimeoutTest {
    @Autowired
    Portfolio_DB_Timeout timeout;

    private final int hikariCP_Default_Connection_Cnt = 10;

    @Test
    void test() throws InterruptedException {
        Thread[] threads = new Thread[hikariCP_Default_Connection_Cnt + 1];
        for (int i = 0; i <= hikariCP_Default_Connection_Cnt; i++) {
            threads[i] = new Thread(timeout::sleep40);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        /*
        예외 스택 트레이스

        Exception in thread "Thread-10" org.springframework.transaction.CannotCreateTransactionException: Could not open JPA EntityManager for transaction

        Caused by: org.hibernate.exception.JDBCConnectionException: Unable to acquire JDBC Connection [HikariPool-1 - Connection is not available, request timed out after 30011ms.] [n/a]

        Caused by: java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 30011ms.
         */
    }

}