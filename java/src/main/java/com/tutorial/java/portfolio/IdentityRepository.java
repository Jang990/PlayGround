package com.tutorial.java.portfolio;

import com.tutorial.java.portfolio.batch.entity.IdentityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends JpaRepository<IdentityEntity, Long> {

}
