package com.tutorial.java.portfolio.batch;

import com.tutorial.java.portfolio.IdentityRepository;
import com.tutorial.java.portfolio.batch.entity.IdentityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Portfolio_Jpa {
    private final IdentityRepository repository;

    @Transactional
    public void saveBulkSomething(List<IdentityEntity> newClient) {
        repository.saveAll(newClient);
    }
}
