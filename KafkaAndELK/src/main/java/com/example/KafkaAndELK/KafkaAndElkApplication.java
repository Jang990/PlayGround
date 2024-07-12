package com.example.KafkaAndELK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KafkaAndElkApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAndElkApplication.class, args);
	}

}
