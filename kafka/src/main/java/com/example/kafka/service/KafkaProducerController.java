package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    /* 카프카는 빠른 스트림 처리 플랫폼 */
    /** get을 호출하면 결과를 얻으려 대기해서 생산자 속도 저하 */
    @GetMapping("/kafka/sync")
    public void sendSync(String message) throws ExecutionException, InterruptedException {
        SendResult<String, String> result = kafkaTemplate.send(topicName, message).get();
        System.out.println(result);
    }

    /** 비동기 처리가 적절 */
    @GetMapping("/kafka/async")
    public void sendAsync(String message) {
        kafkaTemplate.send(topicName, message);
    }

    /** 비동기 처리 결과의 후처리를 원한다면 whenComplete를 활용하기 */
    @GetMapping("/kafka/async/result/console")
    public void sendAsyncWithLog(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
        future.whenComplete((result, ex) -> {
            if(ex == null) // 오류 없이 처리
                System.out.println("Sent message=[" + message + "] " +
                        "with offset=[" + result.getRecordMetadata().offset() + "]");
            else // 오류 발생
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
        });
    }
}