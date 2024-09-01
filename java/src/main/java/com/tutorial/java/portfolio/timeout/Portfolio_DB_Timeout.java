package com.tutorial.java.portfolio.timeout;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Portfolio_DB_Timeout {

    @Transactional
    public void sleep40() {
        // default HikariCP Timeout 30초
        SleepUtil.sleep(40_000);
    }

}
