package com.tutorial.java.portfolio.timeout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class Portfolio_Thread_TimeoutTest {
    @Autowired
    MockMvc mvc;

    @Test
    void test() throws Exception {
        String testUrl = "/timeout";
        mvc.perform(MockMvcRequestBuilders.get(testUrl)).andExpect(MockMvcResultMatchers.status().isOk());
        // 발생하지 않음...
    }

    @Test
    void testOSIV() throws Exception {
        final String testUrl = "/timeout";
        final int hikariCP_Default_Connection_Cnt = 10;
        Thread[] threads = new Thread[hikariCP_Default_Connection_Cnt + 1];
        for (int i = 0; i <= hikariCP_Default_Connection_Cnt; i++) {
            threads[i] = new Thread(() -> {
                try {
                    mvc.perform(MockMvcRequestBuilders.get(testUrl)).andExpect(MockMvcResultMatchers.status().isOk());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // DBCP 타임아웃이 발생하지 않는다...
    }

}