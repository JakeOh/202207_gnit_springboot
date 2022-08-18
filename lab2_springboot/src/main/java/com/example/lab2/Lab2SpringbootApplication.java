package com.example.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication:
// 1. @EnableAutoConfiguration 
// 2. @ComponentScan
// 3. @SpringBootConfiguration 

@SpringBootApplication
public class Lab2SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab2SpringbootApplication.class, args);
	}

}
