package com.example.KafkaAndELK.product.v3.tag;

import com.example.KafkaAndELK.product.v3.entity.TagV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagV3, Long> {
}
