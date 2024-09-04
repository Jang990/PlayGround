package com.tutorial.java.portfolio;

import com.tutorial.java.portfolio.batch.entity.SequenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<SequenceEntity, Long> {

}
