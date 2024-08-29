package com.tutorial.java.portfolio.timeout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Portfolio_Thread_Timeout {
    @GetMapping("/timeout")
    public String hello() {
        log.info("START METHOD");
        // DEFAULT TOMCAT TIMEOUT - 60초
        SleepUtil.sleep(65_000);
        log.info("END METHOD");
        return "Hello World!";
    }
}
