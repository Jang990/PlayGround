package com.example.KafkaAndELK.product.v3.scheduler;


import com.example.KafkaAndELK.product.v3.ProductSearchV3Repository;
import com.example.KafkaAndELK.product.v3.document.ProductInfoV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductInfoScheduler {

    private final ProductTagSyncRepository productTagSyncRepository;
    private final ProductSearchV3Repository searchRepository;

    @Scheduled(cron = "*/30 * * * * *")
    public void sync() {
        log.info("Start Syncing - {}", LocalDateTime.now());
        List<ProductInfoV3> all = productTagSyncRepository.findAll();
        searchRepository.saveAll(all);
    }

}
