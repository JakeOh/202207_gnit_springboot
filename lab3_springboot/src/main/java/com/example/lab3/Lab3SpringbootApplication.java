package com.example.lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lab3SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab3SpringbootApplication.class, args);
	}

}
