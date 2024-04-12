package com.example.kafka.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

@SpringBootTest
class KafkaProducerControllerTest {
    @Autowired
    KafkaProducerController service;
    @Test
    void sendSync() throws ExecutionException, InterruptedException {
        service.sendSync("안녕하세요 sendSync!");
    }

    @Test
    void sendAsync() {
        service.sendAsync("안녕하세요 sendAsync!");
    }

    @Test
    void sendAsyncWithLog() {
        service.sendAsyncWithLog("안녕하세요 sendAsyncWithLog!");
    }
}